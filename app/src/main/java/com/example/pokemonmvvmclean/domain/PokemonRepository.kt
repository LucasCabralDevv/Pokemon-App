package com.example.pokemonmvvmclean.domain

import com.example.pokemonmvvmclean.domain.model.Pokemon

interface PokemonRepository {

    fun getPokemons(pokemonResultCallback: (result: PokemonResult) -> Unit)

    sealed class PokemonResult {
        class Success(val pokemons: List<Pokemon>) : PokemonResult()
        class ApiError(val statusCode: Int) : PokemonResult()
        object ServerError : PokemonResult()
    }
}