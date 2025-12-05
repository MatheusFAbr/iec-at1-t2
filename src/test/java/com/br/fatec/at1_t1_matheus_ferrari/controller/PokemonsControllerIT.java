package com.br.fatec.at1_t1_matheus_ferrari.controller;

import com.br.fatec.at1_t1_matheus_ferrari.CONTROLLER.PokemonsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PokemonsController.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PokemonsControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornarTodosOsPokemonsQuandoGetPokemonsEndpoint() throws Exception {
        mockMvc.perform(get("/atv/pokemons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].nome").value("Pikachu"))
                .andExpect(jsonPath("$[1].nome").value("Charmander"))
                .andExpect(jsonPath("$[2].nome").value("Bulbasaur"));
    }

    @Test
    void deveRetornarPokemonQuandoGetPokemonPorIdEndpointComIdExistente() throws Exception {
        mockMvc.perform(get("/atv/pokemons/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.nome").value("Pikachu"))
                .andExpect(jsonPath("$.tipo").value("Elétrico"))
                .andExpect(jsonPath("$.geracao").value("1"));
    }

    @Test
    void deveRetornarVazioQuandoGetPokemonPorIdEndpointComIdInexistente() throws Exception {
        mockMvc.perform(get("/atv/pokemons/999"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    void deveCriarNovoPokemonQuandoPostPokemonsEndpoint() throws Exception {
        String novoPokemon = """
                {
                    "nome": "Squirtle",
                    "tipo": "Água",
                    "geracao": "1"
                }
                """;

        mockMvc.perform(post("/atv/pokemons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(novoPokemon))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("4"))
                .andExpect(jsonPath("$.nome").value("Squirtle"))
                .andExpect(jsonPath("$.tipo").value("Água"))
                .andExpect(jsonPath("$.geracao").value("1"));
    }

    @Test
    void deveAtualizarPokemonCompletamenteQuandoPutPokemonsEndpoint() throws Exception {
        String pokemonAtualizado = """
                {
                    "nome": "Pikachu Evoluído",
                    "tipo": "Elétrico",
                    "geracao": "1"
                }
                """;

        mockMvc.perform(put("/atv/pokemons/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(pokemonAtualizado))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.nome").value("Pikachu Evoluído"))
                .andExpect(jsonPath("$.tipo").value("Elétrico"));
    }

    @Test
    void deveDeletarPokemonQuandoDeletePokemonsEndpoint() throws Exception {
        mockMvc.perform(delete("/atv/pokemons/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Pokémon 1 removido"));
    }
}
