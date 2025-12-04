package com.br.fatec.at1_t1_matheus_ferrari.CONTROLLER;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atv/pokemons")
public class PokemonsController {

    private final Map<Integer, Map<String, String>> pokemonsDB = new HashMap<>();
    private int nextId = 1;

    public PokemonsController() {
        pokemonsDB.put(1, Map.of(
            "id", "1",
            "nome", "Pikachu",
            "tipo", "Elétrico",
            "geracao", "1"
        ));
        pokemonsDB.put(2, Map.of(
            "id", "2",
            "nome", "Charmander",
            "tipo", "Fogo",
            "geracao", "1"
        ));
        pokemonsDB.put(3, Map.of(
            "id", "3",
            "nome", "Bulbasaur",
            "tipo", "Planta/Veneno",
            "geracao", "1"
        ));
        nextId = 4;
    }

    @GetMapping
    public List<Map<String, String>> getPokemons() {
        return new ArrayList<>(pokemonsDB.values());
    }

    @GetMapping("/{id}")
    public Map<String, String> getPokemonById(@PathVariable int id) {
        return pokemonsDB.get(id);
    }

    @PostMapping
    public Map<String, String> createPokemon(@RequestBody Map<String, String> data) {
        Map<String, String> novoPokemon = new HashMap<>();
        novoPokemon.put("id", String.valueOf(nextId));
        novoPokemon.put("nome", data.get("nome"));
        novoPokemon.put("tipo", data.get("tipo"));
        novoPokemon.put("geracao", data.get("geracao"));

        pokemonsDB.put(nextId, novoPokemon);
        nextId++;

        return novoPokemon;
    }

    @PutMapping("/{id}")
    public Map<String, String> updatePokemon(@PathVariable int id, @RequestBody Map<String, String> data) {
        Map<String, String> pokemonAtualizado = new HashMap<>();
        pokemonAtualizado.put("id", String.valueOf(id));
        pokemonAtualizado.put("nome", data.get("nome"));
        pokemonAtualizado.put("tipo", data.get("tipo"));
        pokemonAtualizado.put("geracao", data.get("geracao"));

        pokemonsDB.put(id, pokemonAtualizado);
        return pokemonAtualizado;
    }

    @DeleteMapping("/{id}")
    public String deletePokemon(@PathVariable int id) {
        pokemonsDB.remove(id);
        return "Pokemon " + id + " removido";
    }

}

