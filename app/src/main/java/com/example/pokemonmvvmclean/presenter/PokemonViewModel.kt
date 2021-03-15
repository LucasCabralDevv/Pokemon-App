package com.example.pokemonmvvmclean.presenter

import androidx.lifecycle.*
import com.example.pokemonmvvmclean.data.model.PokemonBodyResponse
import com.example.pokemonmvvmclean.domain.PokemonRepository
import com.example.pokemonmvvmclean.domain.PokemonResult
import com.example.pokemonmvvmclean.presenter.model.PokemonUiModel
import com.example.pokemonmvvmclean.presenter.model.toUiModel
import kotlinx.coroutines.launch

class PokemonViewModel(private val dataSource: PokemonRepository) : ViewModel() {

    private val _pokemonsLiveData = MutableLiveData<List<PokemonBodyResponse>>()
    val pokemons = _pokemonsLiveData as LiveData<List<PokemonBodyResponse>>

    fun getPokemons() {

            dataSource.getPokemons { results ->
                when (results) {
                    is PokemonResult.Success -> {
                        /*
                        val pokemonList: MutableList<PokemonUiModel> = mutableListOf()
                        for (pokemonModelToUi in results.pokemons) {
                            val pokemon = pokemonModelToUi.toUiModel()
                            pokemonList.add(pokemon)
                        }*/
                        //_pokemonsLiveData.value = results.pokemons.map {
                        //  it.toUiModel()
                        // }
                        _pokemonsLiveData.value = results.pokemons
                    }
                    is PokemonResult.ApiError -> {

                    }
                    is PokemonResult.ServerError -> {

                    }
                }
            }
    }
}

class ViewModelFactory(private val dataSource: PokemonRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonViewModel::class.java)) {
            return PokemonViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}
