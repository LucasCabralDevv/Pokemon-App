package com.example.pokemonmvvmclean.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
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
            binding.pokemonImage.load(pokemon.img)
            binding.pokemonName.text = pokemon.name
        }
        //Glide.with(holder.itemView.context).load(pokemonList[position].img).into(holder.imgPokemon)
        //holder.namePokemon.text = pokemonList[position].name
    }

    override fun getItemCount() = pokemonList.count()

    inner class PokemonViewHolder(val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root)
}