package com.example.pokemonmvvmclean.data.model

import com.example.pokemonmvvmclean.domain.model.Pokemon

data class PokemonBodyResponse(
    val id: Int?,
    val num: String?,
    val name: String?,
    val img: String?,
    val type: List<String>?,
    val height: String?,
    val weight: String?,
    val weaknesses: List<String>?
) {
    fun getPokemonModel() = Pokemon (
        name = this.name,
        img = this.img,
        height = this.height,
        weight = this.weight
        )
}
