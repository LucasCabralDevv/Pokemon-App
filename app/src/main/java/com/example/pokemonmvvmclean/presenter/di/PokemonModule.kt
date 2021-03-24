package com.example.pokemonmvvmclean.presenter.di

import com.example.pokemonmvvmclean.data.PokemonRepository
import com.example.pokemonmvvmclean.data.PokemonRepositoryImpl
import com.example.pokemonmvvmclean.data.api.PokemonService
import com.example.pokemonmvvmclean.data.remote.Service
import com.example.pokemonmvvmclean.domain.GetPokemons
import com.example.pokemonmvvmclean.domain.GetPokemonsUseCase
import com.example.pokemonmvvmclean.presenter.pokemons.PokemonViewModel
import org.koin.dsl.module

val pokemonServiceModule = module {

    single { Service().createService(PokemonService::class.java) }

    single<PokemonRepository> { PokemonRepositoryImpl(get()) }

    single<GetPokemonsUseCase> { GetPokemons(get()) }

    single { PokemonViewModel(get()) }
}