package main.java.org.jazziel.maven.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import main.java.org.jazziel.maven.entidades.Pokemon;
import org.bson.Document;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.print.Doc;

import static com.mongodb.client.model.Filters.eq;
@Service
public class PokemonDao {
    private MongoClient mongoClient= null;
    private MongoCollection<Document> mongoCollection = null;
    private MongoDatabase mongoDatabase = null;

    public PokemonDao() {
        mongoClient = MongoClients.create(System.getenv("mongodb.uri"));
        mongoDatabase = mongoClient.getDatabase("pokedex");
        mongoCollection = mongoDatabase.getCollection("pokemon");
    }

    public Document leerUnArchivoId() {

            Document pokemon = mongoCollection.find(eq("student_id", 10000)).first();
            System.out.println("Pokemon" + pokemon.toJson());
            return pokemon;
    }

    public void escribirEnBaseDatos(Document pokemonNuevo) {
            mongoCollection.insertOne(pokemonNuevo);
    }
}

