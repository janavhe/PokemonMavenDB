package main.java.org.jazziel.maven.servicios;
import main.java.org.jazziel.maven.dao.PokemonDao;
import main.java.org.jazziel.maven.entidades.Pokemon;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.Arrays.asList;
@Service
public class MongoServicioEsribir {
    @Autowired
    private static PokemonDao pokemonDao;


    public MongoServicioEsribir(PokemonDao pokemonDao) {
        this.pokemonDao = pokemonDao;
    }
    public static void escribirEnBaseDatos(Pokemon pokemonNuevo) {
        pokemonDao.escribirEnBaseDatos(generateNewPokemon(pokemonNuevo));
    }

    private static Document generateNewPokemon(Pokemon pokemonNuevo) {
        List<Document> characteristics = asList(new Document("type", "evolution_chain").append("evoluciones", "Evolusion"),
                new Document("type", "types").append("type", pokemonNuevo.getType()));
        return new Document("_id", new ObjectId()).append("name", pokemonNuevo.getName())
                .append("pokemon_id", pokemonNuevo.getId())
                .append("characteristics", characteristics);
    }

}
