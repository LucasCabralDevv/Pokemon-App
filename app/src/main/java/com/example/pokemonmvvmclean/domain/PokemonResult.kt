package com.example.pokemonmvvmclean.domain

import com.example.pokemonmvvmclean.data.model.PokemonBodyResponse

sealed class PokemonResult {
    class Success(val pokemons: List<PokemonBodyResponse>) : PokemonResult()
    class ApiError(val statusCode: Int) : PokemonResult()
    object ServerError : PokemonResult()
}
