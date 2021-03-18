package com.example.pokemonmvvmclean.domain

import com.example.pokemonmvvmclean.data.GetPokemonsException
import com.example.pokemonmvvmclean.data.PokemonRepository
import com.example.pokemonmvvmclean.domain.model.PokemonFactory
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetPokemonsTest {

    private val repository = mockk<PokemonRepository>()

    private val getPokemons = GetPokemons(repository)

    @Test
    fun getPokemons_return_list_with_success() = runBlocking {
        // GIVEN
        coEvery { repository.getPokemons() } returns PokemonFactory.pokemons

        //WHEN
        val result = getPokemons()

        //THEN
        Assert.assertEquals(result.size, PokemonFactory.pokemons.size)
    }

    @Test
    fun getPokemons_return_exception() = runBlocking {
        // GIVEN
        coEvery { repository.getPokemons() } throws GetPokemonsException()

        //WHEN
        val result = getPokemons()

        //THEN
        Assert.assertEquals(result.size, 0)
    }
}