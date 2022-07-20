package main.java.org.jazziel.maven.servicios;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import main.java.org.jazziel.maven.entidades.Pokemon;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

public class MongoServicioBorrar {

    public static Pokemon borrarUnArchivoPorId(String idPokemon) {
        try (
                MongoClient mongoClient = MongoClients.create(System.getenv("mongodb.uri"))) {
            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("pokedex");
            MongoCollection<Document> pokemonCollection = sampleTrainingDB.getCollection("pokemon");

            // delete one document
            Bson filter = eq("pokemon_id", idPokemon);
            DeleteResult result = pokemonCollection.deleteOne(filter);
            System.out.println(idPokemon);
        }
        return null;
    }

    public static Pokemon borrarUnArchivoPorNombre(String nombrePokemon) {
        try (
                MongoClient mongoClient = MongoClients.create(System.getenv("mongodb.uri"))) {
            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("pokedex");
            MongoCollection<Document> pokemonCollection = sampleTrainingDB.getCollection("pokemon");

            // delete one document
            Bson filter = eq("name", nombrePokemon);
            DeleteResult result = pokemonCollection.deleteOne(filter);
            System.out.println(nombrePokemon);
        }
        return null;
    }
}
