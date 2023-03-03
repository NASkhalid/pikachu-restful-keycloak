package org.sid.pokemonservice.service;

import org.sid.pokemonservice.entity.Pokemon;

import java.util.List;


public interface PokemonService {
    List<Pokemon> getPokemons();

    Pokemon addPokemon(Pokemon pokemon);

    Pokemon updatePokemon(Long id, Pokemon pokemon);
}
