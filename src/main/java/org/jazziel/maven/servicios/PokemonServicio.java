package main.java.org.jazziel.maven.servicios;

import main.java.org.jazziel.maven.dao.PokemonDao;
import main.java.org.jazziel.maven.entidades.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class PokemonServicio {

    @Autowired
    private static PokemonDao pokemonDao;

    public PokemonServicio(PokemonDao pokemonDao) {
        this.pokemonDao = pokemonDao;
    }

    public static Pokemon getPokemonById(String idPokemon) throws JSONException {

        final String uri = "https://pokeapi.co/api/v2/pokemon/" + idPokemon;

        final RestTemplate restTemplate = new RestTemplate();
        final String result = restTemplate.getForObject(uri, String.class);
        JSONObject jsonObject= new JSONObject(result);

        String name = jsonObject.getString("name");
        String type = jsonObject.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name");
        String id = jsonObject.getString("id");
        Pokemon ejemploPokemon = new Pokemon(name,type,id);
        return ejemploPokemon;
    }
    public static Pokemon getPokemonByIdEscribir(String idPokemon) throws JSONException {

        final String uri = "https://pokeapi.co/api/v2/pokemon/" + idPokemon;

        final RestTemplate restTemplate = new RestTemplate();
        final String result = restTemplate.getForObject(uri, String.class);
        JSONObject jsonObject= new JSONObject(result);

        String name = jsonObject.getString("name");
        String type = jsonObject.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name");
        String id = jsonObject.getString("id");
        Pokemon ejemploPokemon = new Pokemon(name,type,id);
        MongoServicioEsribir.escribirEnBaseDatos(ejemploPokemon);
        return ejemploPokemon;
    }
}
