package org.sid.pokemonservice.controller;

import org.sid.pokemonservice.entity.Pokemon;
import org.sid.pokemonservice.service.impl.PokemonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin("*")
public class PokemonController {

    private final PokemonServiceImpl pokemonService;

    public PokemonController(PokemonServiceImpl pokemonService) {
        this.pokemonService = pokemonService;
    }


    @GetMapping("/pokemon")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<Pokemon>> recupererPokemons() {
        List<Pokemon> pokemons = pokemonService.getPokemons();
        return new ResponseEntity<>(pokemons, HttpStatus.OK);
    }


    @PostMapping("/pokemon")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Pokemon> ajouterPokemon(@RequestBody Pokemon pokemon) {
        Pokemon savedPokemon = pokemonService.addPokemon(pokemon);
        return new ResponseEntity<>(savedPokemon, HttpStatus.OK);
    }


    @PutMapping("/pokemon/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Pokemon> modifierPokemon(@PathVariable("id") Long id,@RequestBody Pokemon pokemon) {
        Pokemon updatePokemon = pokemonService.updatePokemon(id,pokemon);
        return new ResponseEntity<>(updatePokemon, HttpStatus.OK);
    }

}
