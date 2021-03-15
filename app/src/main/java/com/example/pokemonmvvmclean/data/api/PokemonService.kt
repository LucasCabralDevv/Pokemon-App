package com.example.pokemonmvvmclean.data.api

import com.example.pokemonmvvmclean.data.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {

    @GET("pokedex.json")
    fun getListPokemon(): Call<PokemonResponse>
}