package com.example.pokemonmvvmclean.domain

import com.example.pokemonmvvmclean.data.model.PokemonBodyResponse
import com.example.pokemonmvvmclean.domain.model.Pokemon

interface PokemonRepository {

    fun getPokemons(pokemonResultCallback: (result: PokemonResult) -> Unit)
}