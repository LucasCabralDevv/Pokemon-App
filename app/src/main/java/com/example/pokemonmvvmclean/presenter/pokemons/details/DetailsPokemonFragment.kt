package com.example.pokemonmvvmclean.presenter.pokemons.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.pokemonmvvmclean.R

class DetailsPokemonFragment : Fragment() {

    private val navController: NavController by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_pokemon, container, false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        navController.popBackStack(R.id.pokemonFragment, false)
        return super.onOptionsItemSelected(item)
    }
}