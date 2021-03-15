package com.example.pokemonmvvmclean.domain.model

import com.example.pokemonmvvmclean.presenter.model.PokemonUiModel

data class Pokemon(
    val name: String?,
    val img: String?,
    val height: String?,
    val weight: String?
) {
    fun getPokemonUiModel() = PokemonUiModel(
        name = this.name,
        img = this.img
    )
}
