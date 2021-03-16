package com.example.pokemonmvvmclean.data

import com.example.pokemonmvvmclean.data.api.PokemonService
import com.example.pokemonmvvmclean.data.model.toPokemonModel
import com.example.pokemonmvvmclean.data.remote.Output
import com.example.pokemonmvvmclean.data.remote.parseResponse
import com.example.pokemonmvvmclean.domain.model.Pokemon
import java.lang.Exception

class PokemonRepositoryImpl(
    private val service: PokemonService
) : PokemonRepository {

    override suspend fun getPokemons(): List<Pokemon> {
        val result = service.getListPokemon().parseResponse()

        return when (result) {

            is Output.Success -> {
                val pokemonResponseList = result.value.pokemon

                pokemonResponseList.map {
                    it.toPokemonModel()
                }
            }
            is Output.Failure -> throw GetPokemonsException()
        }
    }


}

interface PokemonRepository {

    suspend fun getPokemons(): List<Pokemon>
}

class GetPokemonsException : Exception()