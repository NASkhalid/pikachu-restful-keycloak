package org.sid.pokemonservice.repository;

import org.sid.pokemonservice.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    @Override
    List<Pokemon> findAll();
}
