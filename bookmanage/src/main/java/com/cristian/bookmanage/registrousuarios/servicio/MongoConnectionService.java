package com.cristian.bookmanage.registrousuarios.servicio;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class MongoConnectionService {
    private MongoDatabase mongoDatabase;

    public MongoConnectionService() {
        checkMongoDBConnection();
    }

    public void checkMongoDBConnection() {
        String connectionString = "mongodb+srv://mongo:mongo@proyectoad.xgtsf.mongodb.net/?retryWrites=true&w=majority&appName=ProyectoAD";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                mongoDatabase = mongoClient.getDatabase("bookmanagedb");
                mongoDatabase.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
                System.out.println("Error connecting to MongoDB: " + e.getMessage());
            }
        }
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
}
