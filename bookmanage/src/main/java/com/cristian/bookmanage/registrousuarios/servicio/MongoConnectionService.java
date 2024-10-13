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

@Service
public class MongoConnectionService {

    private final MongoClient mongoClient;
    private final MongoDatabase mongoDatabase;

    @Autowired
    private UsuarioRepositorioMongoDb usuarioRepositorioMongoDb;

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

    public void save(UsuarioRegistroDTO registroDTO) {
        Document document = new Document("Nombre", registroDTO.getNombre())
                .append("Email", registroDTO.getEmail())
                .append("Password", registroDTO.getPassword());

        try {
            mongoDatabase.getCollection("usuarios").insertOne(document);
            System.out.println("Usuario guardado en MongoDB: " + document.toJson());
        } catch (Exception e) {
            System.out.println("Error al guardar en MongoDB: " + e.getMessage());
        }
    }

    public boolean checkUser(String email, String password){

        MongoCollection<Document> collection = mongoDatabase.getCollection("usuarios");

        Document query = new Document("Email", email).append("Password", password);
        MongoCursor<Document> cursor = collection.find(query).iterator();

        boolean userExists = cursor.hasNext();

        cursor.close();

        return userExists;

    }


}
