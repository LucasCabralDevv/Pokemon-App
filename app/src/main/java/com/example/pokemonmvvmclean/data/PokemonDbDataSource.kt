package com.example.pokemonmvvmclean.data

import com.example.pokemonmvvmclean.data.api.PokemonService
import com.example.pokemonmvvmclean.data.api.RetrofitClient
import com.example.pokemonmvvmclean.data.model.PokemonResponse
import com.example.pokemonmvvmclean.data.model.toPokemonModel
import com.example.pokemonmvvmclean.domain.PokemonRepository
import com.example.pokemonmvvmclean.domain.PokemonResult
import com.example.pokemonmvvmclean.domain.model.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonDbDataSource : PokemonRepository {

    override fun getPokemons(pokemonResultCallback: (result: PokemonResult) -> Unit) {

        val remote = RetrofitClient.createService(PokemonService::class.java)
        val call: Call<PokemonResponse> = remote.getListPokemon()


        call.enqueue(object : Callback<PokemonResponse>{
            override fun onResponse(call: Call<PokemonResponse>,response: Response<PokemonResponse>) {
                val str = ""
                when {
                    response.isSuccessful -> {

                        //val pokemons: MutableList<Pokemon> = mutableListOf()
                        response.body()?.let {
                            /*for (result in it.pokemon) {
                                val pokemon = result.toPokemonModel()
                                pokemons.add(pokemon)
                            }*/
                            val pokemon = it.pokemon

                            pokemonResultCallback(PokemonResult.Success(pokemon))
                        }
                    }
                    else -> {
                        pokemonResultCallback(PokemonResult.ApiError(response.code()))
                    }
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                pokemonResultCallback(PokemonResult.ServerError)
            }

        })
    }
}