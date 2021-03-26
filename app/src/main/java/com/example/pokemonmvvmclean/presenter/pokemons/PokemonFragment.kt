package com.example.pokemonmvvmclean.presenter.pokemons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemonmvvmclean.R
import com.example.pokemonmvvmclean.databinding.PokemonFragmentBinding
import com.example.pokemonmvvmclean.extensions.navigateWithAnimations
import com.example.pokemonmvvmclean.presenter.adapter.PokemonAdapter
import com.example.pokemonmvvmclean.presenter.model.PokemonUiModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PokemonFragment : Fragment() {

    private val viewModel: PokemonViewModel by sharedViewModel()

    private lateinit var binding: PokemonFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PokemonFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemons.observe(viewLifecycleOwner, Observer { pokemonList ->
            setupRecyclerView(pokemonList)
        })

        viewModel.getPokemons()
    }

    private fun setupRecyclerView(pokemons: List<PokemonUiModel>) {
        with(binding.rvPokemon) {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = PokemonAdapter(pokemons) { pokemon ->
                val directions = PokemonFragmentDirections
                    .actionPokemonFragmentToDetailsPokemonFragment(pokemon)
            findNavController().navigateWithAnimations(directions)
            }
        }
    }
}