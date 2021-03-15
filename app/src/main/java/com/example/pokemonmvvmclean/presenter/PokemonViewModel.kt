package com.example.pokemonmvvmclean.presenter

import androidx.lifecycle.*
import com.example.pokemonmvvmclean.domain.PokemonRepository
import com.example.pokemonmvvmclean.presenter.model.PokemonUiModel
import kotlinx.coroutines.launch

class PokemonViewModel(private val dataSource: PokemonRepository) : ViewModel() {

    private val _pokemonsLiveData = MutableLiveData<List<PokemonUiModel>>()
    val pokemons = _pokemonsLiveData as LiveData<List<PokemonUiModel>>

    fun getPokemons() {
        viewModelScope.launch {
            dataSource.getPokemons { result ->  
                when (result) {
                    is PokemonRepository.PokemonResult.Success -> {
                        val pokemonList: MutableList<PokemonUiModel> = mutableListOf()
                        for (result in result.pokemons) {
                            val pokemon = result.getPokemonUiModel()
                            pokemonList.add(pokemon)
                        }
                        _pokemonsLiveData.value = pokemonList
                    }
                    is PokemonRepository.PokemonResult.ApiError -> {
                        if (result.statusCode == 401) {
                            _pokemonsLiveData.value = listOf()
                        }
                    }
                    is PokemonRepository.PokemonResult.ServerError -> {
                        _pokemonsLiveData.value = listOf()
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
}