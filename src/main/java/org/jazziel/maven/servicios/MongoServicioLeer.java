package main.java.org.jazziel.maven.servicios;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class MongoServicioLeer {

    public static void leerUnArchivoId () {

        try (MongoClient mongoClient = MongoClients.create(System.getenv("mongodb.uri"))) {
            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("pokedex");
            MongoCollection<Document> pokemonCollection = sampleTrainingDB.getCollection("pokemon");

            Document pokemon = pokemonCollection.find(eq("student_id", 10000)).first();
            System.out.println("Pokemon" + pokemon.toJson());
        }
    }
}
