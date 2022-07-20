package main.java.org.jazziel.maven.controladores;


import main.java.org.jazziel.maven.entidades.Pokemon;
import main.java.org.jazziel.maven.servicios.MongoServicioBorrar;
import main.java.org.jazziel.maven.servicios.PokemonServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/pokemonDB/v1/")
@RestController
public class PokemonControlador {

    @Autowired
    private static PokemonServicio pokemonServicio;

    public PokemonControlador(PokemonServicio pokemonServicio) {
        this.pokemonServicio = pokemonServicio;
    }

    @GetMapping("/getPokemonId/{idPokemon}")
    public Pokemon getPokemon (@PathVariable String idPokemon) throws JSONException{
        return pokemonServicio.getPokemonById(idPokemon);
    }

    @GetMapping("/getPokemonIdEscribir/{idPokemon}")
    public Pokemon getPokemonEscribir (@PathVariable String idPokemon) throws JSONException{
        return pokemonServicio.getPokemonByIdEscribir(idPokemon);
    }

    @GetMapping("/getPokemonIdBorrar/{idPokemon}")
    public Pokemon getPokemonBorrar (@PathVariable String idPokemon) throws JSONException{
        return MongoServicioBorrar.borrarUnArchivoPorId(idPokemon);
    }
    @GetMapping("/getPokemonNombreBorrar/{nombrePokemon}")
    public Pokemon getPokemonBorrarnombre (@PathVariable String nombrePokemon) throws JSONException{
        return MongoServicioBorrar.borrarUnArchivoPorNombre(nombrePokemon);
    }
}
