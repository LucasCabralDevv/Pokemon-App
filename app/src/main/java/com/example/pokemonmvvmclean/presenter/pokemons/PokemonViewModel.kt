package com.example.pokemonmvvmclean.presenter.pokemons

import androidx.lifecycle.*
import com.example.pokemonmvvmclean.domain.GetPokemonsUseCase
import com.example.pokemonmvvmclean.presenter.model.PokemonUiModel
import com.example.pokemonmvvmclean.presenter.model.toPokemonUiModel
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    private val _pokemonsLiveData = MutableLiveData<List<PokemonUiModel>>()
    val pokemons = _pokemonsLiveData as LiveData<List<PokemonUiModel>>

    fun getPokemons() {
        viewModelScope.launch {
            val pokemonList = getPokemonsUseCase()

            _pokemonsLiveData.value = pokemonList.map { Pokemon ->
                Pokemon.toPokemonUiModel()
            }
        }
    }
}
