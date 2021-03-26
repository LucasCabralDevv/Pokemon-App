package com.example.pokemonmvvmclean.presenter.pokemons.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pokemonmvvmclean.R
import kotlinx.android.synthetic.main.fragment_details_pokemon.*

class DetailsPokemonFragment : Fragment() {

    val args: DetailsPokemonFragmentArgs by navArgs()

    private val navController: NavController by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_pokemon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemonName = args.pokemon.name
        detailsPokemonNameTextView.text = pokemonName
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        navController.popBackStack(R.id.pokemonFragment, false)
        return super.onOptionsItemSelected(item)
    }
}