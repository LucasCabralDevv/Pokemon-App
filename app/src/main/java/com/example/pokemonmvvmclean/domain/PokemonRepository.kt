package com.example.pokemonmvvmclean.domain

interface PokemonRepository {

    fun getPokemons(pokemonResultCallback: (result: PokemonResult) -> Unit)
}