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
import com.bumptech.glide.Glide
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

        Glide.with(requireContext()).load(args.pokemon.img).into(detailsImagePokemonImageView)
        detailsNamePokemonTextView.text = args.pokemon.name
        detailsHeightPokemonTextView.text = args.pokemon.height
        detailsWeightPokemonTextView.text = args.pokemon.weight
        detailsWeaknessesPokemonTextView.text = args.pokemon.weaknesses.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        navController.popBackStack(R.id.pokemonFragment, false)
        return super.onOptionsItemSelected(item)
    }
}