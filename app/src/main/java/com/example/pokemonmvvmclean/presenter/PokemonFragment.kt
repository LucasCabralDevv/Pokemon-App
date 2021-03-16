package com.example.pokemonmvvmclean.presenter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemonmvvmclean.R
import com.example.pokemonmvvmclean.presenter.adapter.PokemonAdapter
import kotlinx.android.synthetic.main.pokemon_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PokemonFragment : Fragment() {

    private val viewModel: PokemonViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pokemon_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemons.observe(viewLifecycleOwner, Observer {
            with(rv_pokemon) {
                //setHasFixedSize(true)
                //layoutManager = GridLayoutManager(requireContext(), 2)
                adapter = PokemonAdapter(it)
            }
        })

        viewModel.getPokemons()
    }
}