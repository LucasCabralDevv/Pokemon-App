package com.example.pokemonmvvmclean.domain

import com.example.pokemonmvvmclean.data.PokemonRepository
import com.example.pokemonmvvmclean.domain.model.Pokemon
import java.lang.Exception

class GetPokemons(
    private val pokemonRepository: PokemonRepository
) : GetPokemonsUseCase {

    override suspend fun invoke(): List<Pokemon> = try {
            pokemonRepository.getPokemons()
    } catch (ex: Exception) {
        listOf()
    }

}

interface GetPokemonsUseCase {
    suspend operator fun invoke(): List<Pokemon>
}

