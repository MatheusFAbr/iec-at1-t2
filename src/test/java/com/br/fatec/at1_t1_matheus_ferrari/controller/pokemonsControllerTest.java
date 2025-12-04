package com.br.fatec.at1_t1_matheus_ferrari.controller;

import com.br.fatec.at1_t1_matheus_ferrari.CONTROLLER.PokemonsController;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class PokemonsControllerTest {

    private final PokemonsController controller = new PokemonsController();

    // 1. Teste para listar todos os pokemons
    @Test
    void deveRetornarTodosOsPokemons() {
        List<Map<String, String>> pokemons = controller.getPokemons();
        assertEquals(3, pokemons.size());
        assertEquals("Pikachu", pokemons.get(0).get("nome"));
    }

    // 2. Teste para buscar pokemon por ID existente
    @Test
    void deveRetornarPokemonQuandoIdExiste() {
        Map<String, String> pokemon = controller.getPokemonById(1);
        assertNotNull(pokemon);
        assertEquals("1", pokemon.get("id"));
        assertEquals("Pikachu", pokemon.get("nome"));
        assertEquals("Elétrico", pokemon.get("tipo"));
    }

    // 3. Teste para buscar pokemon por ID inexistente
    @Test
    void deveRetornarNullQuandoIdNaoExiste() {
        Map<String, String> pokemon = controller.getPokemonById(999);
        assertEquals(null, pokemon);
    }

    // 4. Teste para criar novo pokemon
    @Test
    void deveCriarNovoPokemon() {
        Map<String, String> novoPokemon = Map.of(
            "nome", "Squirtle",
            "tipo", "Água",
            "geracao", "1"
        );
        Map<String, String> resultado = controller.createPokemon(novoPokemon);

        assertEquals("Squirtle", resultado.get("nome"));
        assertEquals("Água", resultado.get("tipo"));
        assertEquals("1", resultado.get("geracao"));
        assertEquals("4", resultado.get("id"));
    }

    // 5. Teste para atualizar pokemon existente
    @Test
    void deveAtualizarPokemon() {
        Map<String, String> dadosAtualizacao = Map.of(
            "nome", "Pikachu Evoluído",
            "tipo", "Elétrico",
            "geracao", "1"
        );
        Map<String, String> resultado = controller.updatePokemon(1, dadosAtualizacao);

        assertEquals("Pikachu Evoluído", resultado.get("nome"));
        assertEquals("Elétrico", resultado.get("tipo"));
    }

    // 6. Teste para deletar pokemon
    @Test
    void deveDeletarPokemonERetornarMensagem() {
        String resultado = controller.deletePokemon(1);
        assertEquals("Pokemon 1 removido", resultado);
    }

}
