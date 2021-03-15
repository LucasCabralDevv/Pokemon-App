package com.example.pokemonmvvmclean.presenter.model

import com.example.pokemonmvvmclean.domain.model.Pokemon

data class PokemonUiModel (
    val name: String?,
    val img: String?
)

fun Pokemon.toUiModel() = PokemonUiModel(
    name = this.name,
    img = this.img
)

