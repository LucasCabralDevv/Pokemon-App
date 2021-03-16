package com.example.pokemonmvvmclean.data.api

import com.example.pokemonmvvmclean.data.model.PokemonBodyResponse
import com.example.pokemonmvvmclean.data.remote.BaseResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonService {
    @GET("pokedex.json")
    suspend fun getListPokemon(): Response<BaseResponse<PokemonBodyResponse>>
}