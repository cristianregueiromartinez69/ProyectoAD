package com.cristian.bookmanage.registrolibros.servicio;

import com.cristian.bookmanage.iniciosesionusuarios.modelo.DatosLogin;
import com.cristian.bookmanage.registrolibros.dto.LibrosRegistroDTO;
import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;
import com.cristian.bookmanage.registrousuarios.modelo.UsuariosMongoDb;
import com.cristian.bookmanage.registrousuarios.repositorio.UsuarioRepositorioMongoDb;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Clase para manejar la lógica de la conexion y registro de libros en la base de datos de mongoDb
 * @author cristian
 * @version 1.0
 */
@Service
public class MongoConnectionService {

    //variables privadas para establecer la conexion con mongo db
    private final MongoClient mongoClient;
    private final MongoDatabase mongoDatabase;

    //inyeccion de dependencias con el repositorio de mongoDb
    @Autowired
    private UsuarioRepositorioMongoDb usuarioRepositorioMongoDb;

    /**
     * Contructor de la clase en el cual establecemos la conexion:
     * 1. introducimos la ruta
     * 2. establecemos la version y la construimos
     * 3. Establecemos el cliente de mongo y metemos como parametro la url
     * 4. construimos la api con el objeto de serverApi que tiene la version api de mongo
     * 5. contruimos los objetos e iniciamos el cliente de mongo con lo anterior y nos conectamos a la base de mongo
     */
    public MongoConnectionService() {
        String connectionString = "mongodb+srv://mongo:mongo@proyectoad.xgtsf.mongodb.net/?retryWrites=true&w=majority&appName=ProyectoAD";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        this.mongoClient = MongoClients.create(settings);
        this.mongoDatabase = mongoClient.getDatabase("bookmanagedb");
    }

    /**
     * Metodo para el registro libros a la base de mongoDb
     * @param librosRegistroDTO el objeto registroDTO con los datos de registro del libro
     */
    public void save(LibrosRegistroDTO librosRegistroDTO) {
        /**
         * Este es un objeto document que sigue las reglas de las colecciones de mongodb, por lo tanto nos sirve para introeducir datos
         * creamos el objeto y añadimos con append los datos del objeto registroDTO
         */
        Document document = new Document("ISBN", librosRegistroDTO.getIsbn())
                .append("Autor", librosRegistroDTO.getAutor())
                .append("Nombre", librosRegistroDTO.getNombre())
                .append("Fecha de lectura", librosRegistroDTO.getFechaLectura())
                .append("Fecha de registro", librosRegistroDTO.getFechaRegistro());

        /**
         * Obtenemos la coleccion de la base de datos y con el metodo insertOne, insertamos los datos
         */
        try {
            mongoDatabase.getCollection("libros").insertOne(document);
            System.out.println("Libro guardado en MongoDB: " + document.toJson());
        } catch (Exception e) {
            System.out.println("Error al guardar en MongoDB: " + e.getMessage());
        }
    }




}
