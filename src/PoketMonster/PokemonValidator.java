package PoketMonster;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PokemonValidator {
    public static final String[] VALID_TYPES = { "Fire", "Water", "Grass" };

    public static boolean isValidPokemonListFormat(String pokemonList) {
        if (pokemonList == null || pokemonList.isEmpty())
            return false;

        String[] pokemons = pokemonList.trim().split(", ");
        
        for (String pokemon : pokemons) {
            String[] parts = pokemon.trim().split("/");
            if (parts.length != 2)
                return false;

            String name = parts[0];
            if (!name.matches("[A-Z][a-z]*"))
                return false;

            String type = parts[1];
            if (!Arrays.asList(VALID_TYPES).contains(type))
                return false;
        }

        return true;
    }

    public static boolean isValidPokemon(String pokemon) {
        String[] parts = pokemon.split("/");
        if (parts.length != 2) {
            return false;
        }
    
        String name = parts[0];
        if (!name.matches("[A-Z][a-z]*")) {
            return false;
        }
    
        String type = parts[1];
        return Arrays.asList(VALID_TYPES).contains(type);
    }

    public static boolean isValidTypeListFormat(String typeList) {
        if (typeList == null || typeList.isEmpty())
          return false;
        
        String[] types = typeList.trim().split("\\s+");
        
        for (String type : types)
          if (!Arrays.asList(VALID_TYPES).contains(type))
            return false;
        
        return true;
    }

    public static boolean pokemonIsAvailableInPokedex(String pokedex, String types) {
        String[] pokemonesArray = pokedex.split(",");
        String[] tiposPokemones = new String[pokemonesArray.length];

        for (int i = 0; i < pokemonesArray.length; i++) {
            String tipo = pokemonesArray[i].split("/")[1];
            tiposPokemones[i] = tipo;
        }

        String pokedexTypes = "";

        for (String it : tiposPokemones) {
            pokedexTypes += it + " ";
        }

        Map<String, Integer> ocurrencias = new HashMap<>();
        for (String tipo : Arrays.asList(VALID_TYPES)) {
            ocurrencias.put(tipo, 0);
        }

        for (String tipo : pokedexTypes.split(" ")) {
            ocurrencias.put(tipo, ocurrencias.getOrDefault(tipo, 0) + 1);
        }

        for (String tipo : types.split(" ")) {
            ocurrencias.put(tipo, ocurrencias.getOrDefault(tipo, 0) - 1);
        }

        for (String tipo : ocurrencias.keySet()) {
            if (ocurrencias.get(tipo) > 0) {
                return true;
            }
        }
        return false;
    }
}

