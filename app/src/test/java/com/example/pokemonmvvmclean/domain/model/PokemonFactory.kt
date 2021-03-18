package com.example.pokemonmvvmclean.domain.model

object PokemonFactory {

    val pokemons = listOf(
        Pokemon(
            1,
            "001",
            "Bulbasaur",
            "http://www.serebii.net/pokemongo/pokemon/001.png"
        ),
        Pokemon(
            2,
            "002",
            "Ivysaur",
            "http://www.serebii.net/pokemongo/pokemon/002.png"
        ),
        Pokemon(
            3,
            "003",
            "Venusaur",
            "http://www.serebii.net/pokemongo/pokemon/003.png"
        ),
        Pokemon(
            4,
            "004",
            "Charmander",
            "http://www.serebii.net/pokemongo/pokemon/004.png"
        )
    )
}