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
import com.example.pokemonmvvmclean.databinding.FragmentDetailsPokemonBinding

class DetailsPokemonFragment : Fragment() {

    val args: DetailsPokemonFragmentArgs by navArgs()
    private lateinit var detailsBinding: FragmentDetailsPokemonBinding

    private val navController: NavController by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailsBinding = FragmentDetailsPokemonBinding.inflate(inflater, container, false)
        return detailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        navController.popBackStack(R.id.pokemonFragment, false)
        return super.onOptionsItemSelected(item)
    }

    private fun setupViews() {
        with(detailsBinding){
            Glide.with(requireContext()).load(args.pokemon.img).into(detailsHeaderImageView)
            Glide.with(requireContext()).load(args.pokemon.img).into(detailsImagePokemonImageView)

            detailsNamePokemonTextView.text = args.pokemon.name
            detailsHeightPokemonTextView.text = args.pokemon.height
            detailsWeightPokemonTextView.text = args.pokemon.weight
            detailsWeaknessesPokemonTextView.text = args.pokemon.weaknesses.toString()
        }
    }
}