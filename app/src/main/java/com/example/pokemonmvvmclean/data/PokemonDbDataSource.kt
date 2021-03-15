package com.example.pokemonmvvmclean.data

import com.example.pokemonmvvmclean.data.api.PokemonService
import com.example.pokemonmvvmclean.data.api.RetrofitClient
import com.example.pokemonmvvmclean.data.model.PokemonResponse
import com.example.pokemonmvvmclean.domain.PokemonRepository
import com.example.pokemonmvvmclean.domain.model.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonDbDataSource : PokemonRepository {

    override suspend fun getPokemons(pokemonResultCallback: (result: PokemonRepository.PokemonResult) -> Unit) {

        val remote = RetrofitClient.createService(PokemonService::class.java)
        val call: Call<PokemonResponse> = remote.getListPokemon()

        call.enqueue(object : Callback<PokemonResponse>{
            override fun onResponse(call: Call<PokemonResponse>,response: Response<PokemonResponse>) {
                when {
                    response.isSuccessful -> {
                        val pokemons: MutableList<Pokemon> = mutableListOf()

                        response.body()?.let {
                            for (result in it.pokemon) {
                                val pokemon = result.getPokemonModel()
                                pokemons.add(pokemon)
                            }
                            pokemonResultCallback(PokemonRepository.PokemonResult.Success(pokemons))
                        }
                    } else -> {
                        pokemonResultCallback(PokemonRepository.PokemonResult.ApiError(response.code()))
                    }
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                pokemonResultCallback(PokemonRepository.PokemonResult.ServerError)
            }

        })
    }
}