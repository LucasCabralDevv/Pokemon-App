package com.example.pokemonmvvmclean.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemonmvvmclean.R
import com.example.pokemonmvvmclean.presenter.model.PokemonUiModel

class PokemonAdapter(
    private val pokemonList : List<PokemonUiModel>
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(pokemonList[position].img).into(holder.imgPokemon)
        holder.namePokemon.text = pokemonList[position].name
    }

    override fun getItemCount() = pokemonList.count()

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal val imgPokemon: ImageView = itemView.findViewById(R.id.pokemonImage)
        internal val namePokemon: TextView = itemView.findViewById(R.id.pokemonName)
    }
}