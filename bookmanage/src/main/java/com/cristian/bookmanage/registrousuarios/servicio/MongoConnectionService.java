package com.cristian.bookmanage.registrousuarios.servicio;

import com.cristian.bookmanage.iniciosesionusuarios.modelo.DatosLogin;
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
 * Clase para manejar la lógica de la conexion, autenticacion y registro con mongoDb para los usuarios
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
     * Metodo para el registro de usuarios a la base de mongoDb
     * @param registroDTO el objeto registroDTO con los datos de registro de usuario
     */
    public void save(UsuarioRegistroDTO registroDTO) {
        /**
         * Este es un objeto document que sigue las reglas de las colecciones de mongodb, por lo tanto nos sirve para introeducir datos
         * creamos el objeto y añadimos con append los datos del objeto registroDTO
         */
        Document document = new Document("Nombre", registroDTO.getNombre())
                .append("Email", registroDTO.getEmail())
                .append("Password", registroDTO.getPassword());

        /**
         * Obtenemos la coleccion de la base de datos y con el metodo insertOne, insertamos los datos
         */
        try {
            mongoDatabase.getCollection("usuarios").insertOne(document);
            System.out.println("Usuario guardado en MongoDB: " + document.toJson());
        } catch (Exception e) {
            System.out.println("Error al guardar en MongoDB: " + e.getMessage());
        }
    }

    /**
     * Metodo que comprueba el email y password de una coleccion de usuarios
     * @param email el email a comprobar
     * @param password la contraseña a comprobar
     * @return true o false dependiendo de si está o no el usuario
     */
    public boolean checkUser(String email, String password){

        /**
         * estas instrucciones hacen lo siguiente:
         * 1. creamos un objeto coleccion de mongo que es igual a la coleccion usuarios de la base de datos
         * 2. creamos un documento con el email y password a encontrar
         * 3. creamos un cursor para la coleccion de mongo de los usuarios
         * 4. el objetivo es encontrar el email y contraseña
         * 5. creamos un booleano que nos devuelve true o false para confirmar si existe o no el email y password
         * 6. se cierra el cursor
         */
        MongoCollection<Document> collection = mongoDatabase.getCollection("usuarios");

        Document query = new Document("Email", email).append("Password", password);
        MongoCursor<Document> cursor = collection.find(query).iterator();

        boolean userExists = cursor.hasNext();

        cursor.close();

        return userExists;

    }


}
