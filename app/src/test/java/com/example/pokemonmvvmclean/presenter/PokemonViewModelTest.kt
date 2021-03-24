package com.example.pokemonmvvmclean.presenter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pokemonmvvmclean.domain.GetPokemonsUseCase
import com.example.pokemonmvvmclean.domain.model.PokemonFactory
import com.example.pokemonmvvmclean.presenter.pokemons.PokemonViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class PokemonViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val useCase = mockk<GetPokemonsUseCase>()
    private val viewModel = PokemonViewModel(useCase)

    @Test
    fun `when useCase is instantiated with success return a list`() = runBlocking {
        // GIVEN
        coEvery { useCase.invoke() } returns PokemonFactory.pokemons

        //WHEN
        val result = useCase()

        //THEN
        Assert.assertEquals(result.size, PokemonFactory.pokemons.size)
    }
}