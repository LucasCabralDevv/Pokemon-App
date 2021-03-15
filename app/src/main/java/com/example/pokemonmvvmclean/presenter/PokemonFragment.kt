package com.example.pokemonmvvmclean.presenter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonmvvmclean.R
import com.example.pokemonmvvmclean.presenter.adapter.PokemonAdapter
import kotlinx.android.synthetic.main.pokemon_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonFragment : Fragment() {

    private val viewModel: PokemonViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pokemon_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemons.observe(viewLifecycleOwner) { pokemonList ->
            with(rv_pokemon) {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, 2)
                adapter = PokemonAdapter(pokemonList)
            }
        }
        viewModel.getPokemons()
    }
}