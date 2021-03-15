package com.example.pokemonmvvmclean.data.model

data class PokemonBodyResponse(
    val id: Int?,
    val num: String?,
    val name: String?,
    val img: String?,
    val type: List<String>?,
    val height: String?,
    val weight: String?,
    val weaknesses: List<String>?
)
