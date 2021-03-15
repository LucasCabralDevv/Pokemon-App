package com.example.pokemonmvvmclean.presenter.di

import com.example.pokemonmvvmclean.data.PokemonDbDataSource
import com.example.pokemonmvvmclean.domain.PokemonRepository
import com.example.pokemonmvvmclean.presenter.PokemonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pokemonModule = module {
    factory<PokemonRepository> {
        PokemonDbDataSource()
    }
    viewModel {
        PokemonViewModel(
            get()
        )
    }
}