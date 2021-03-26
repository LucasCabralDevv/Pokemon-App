package com.example.pokemonmvvmclean.data.model

import com.example.pokemonmvvmclean.domain.model.Pokemon

data class PokemonBodyResponse(
    val id: Int,
    val num: String,
    val name: String,
    val img: String,
    val type: List<String>,
    val height: String,
    val weight: String,
    val weaknesses: List<String>,
    val next_evolution: List<Evolution>,
    val prev_evolution: List<Evolution>
)

fun PokemonBodyResponse.toPokemonModel() = Pokemon(
    id = this.id,
    num = this.num,
    name = this.name,
    img = this.img,
    height = this.height,
    weight = this.weight,
    weaknesses = this.weaknesses
)
