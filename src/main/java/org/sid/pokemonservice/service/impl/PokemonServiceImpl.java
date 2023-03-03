package org.sid.pokemonservice.service.impl;


import org.sid.pokemonservice.entity.Pokemon;
import org.sid.pokemonservice.repository.PokemonRepository;
import org.sid.pokemonservice.service.PokemonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemonRepository.findAll();
    }

    @Override
    public Pokemon addPokemon(Pokemon pokemon) {
        Pokemon savedPokemon = pokemonRepository.save(pokemon);
        return savedPokemon;
    }


    @Override
    public Pokemon updatePokemon(Long id, Pokemon pokemon) {
        Pokemon pokemonTrouvee = pokemonRepository.findById(id).get();
        if(pokemonTrouvee != null && pokemon != null) {
            pokemonTrouvee.setCp(pokemon.getCp());
            pokemonTrouvee.setHp(pokemon.getHp());
            pokemonTrouvee.setName(pokemon.getName());
            pokemonTrouvee.setPicture(pokemon.getPicture());
            pokemonTrouvee.setType(pokemon.getType());

            pokemonRepository.save(pokemonTrouvee);
        }
        return pokemonTrouvee;
    }
}
