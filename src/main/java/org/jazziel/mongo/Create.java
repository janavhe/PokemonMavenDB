package main.java.org.jazziel.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertManyOptions;
import main.java.org.jazziel.maven.entidades.Pokemon;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Create {
    private static final String nombrePrueba = "Pikachu";
    private static final int idPrueba = 25;
    private static final String typePrueba = "Pikachu";

    public static void main(String[] argsm) {
        try (MongoClient mongoClient = MongoClients.create(System.getenv("mongodb.uri"))) {
            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("pokedex");
            MongoCollection<Document> pokemonCollection = sampleTrainingDB.getCollection("pokemon");
            newPokemon(pokemonCollection);

        }
    }


    private static void newPokemon(MongoCollection<Document> pokemonCollection) {
        pokemonCollection.insertOne(generateNewPokemon(nombrePrueba, idPrueba, typePrueba));
        System.out.println("Se genero nuevo pokemon/n");
    }

    private static Document generateNewPokemon(String pokemonName, int pokemonId, String tipoPrueba) {
        List<Document> characteristics = asList(new Document("type", "evolution_chain").append("evoluciones", "Evolusion"),
                new Document("type", "types").append("type", tipoPrueba));
        return new Document("_id", new ObjectId()).append("name", pokemonName)
                .append("pokemon_id", pokemonId)
                .append("characteristics", characteristics);
    }
}
