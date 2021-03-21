package com.example.pokemonmvvmclean.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.example.pokemonmvvmclean.R
import com.example.pokemonmvvmclean.databinding.ItemPokemonBinding
import com.example.pokemonmvvmclean.presenter.model.PokemonUiModel

class PokemonAdapter(
    private val pokemonList : List<PokemonUiModel>
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val itemView = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        with(holder) {
            //Glide.with(binding.pokemonImage.context).load(pokemon.img).into(binding.pokemonImage)
            binding.pokemonName.text = pokemon.name
            binding.pokemonImage.load(pokemon.img)
        }
    }

    override fun getItemCount() = pokemonList.count()

    inner class PokemonViewHolder(val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root)
}