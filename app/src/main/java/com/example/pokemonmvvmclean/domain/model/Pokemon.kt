package com.example.pokemonmvvmclean.domain.model

import com.example.pokemonmvvmclean.data.model.PokemonBodyResponse

data class Pokemon(
    val name: String?,
    val img: String?,
)

fun PokemonBodyResponse.toPokemon() = Pokemon(
    name = this.name,
    img = this.img
)
