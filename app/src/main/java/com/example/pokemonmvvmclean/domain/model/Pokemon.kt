package com.example.pokemonmvvmclean.domain.model

data class Pokemon(
    val id: Int,
    val num: String,
    val name: String,
    val img: String,
    val height: String,
    val weight: String,
    val weaknesses: List<String>
)
