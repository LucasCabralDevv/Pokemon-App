package com.example.pokemonmvvmclean.presenter.model

import android.os.Parcelable
import com.example.pokemonmvvmclean.domain.model.Pokemon
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonUiModel (
    val name: String,
    val img: String,
    val height: String,
    val weight: String,
    val weaknesses: List<String>
) : Parcelable

fun Pokemon.toPokemonUiModel() = PokemonUiModel(
    name = this.name,
    img = this.img,
    height = this.height,
    weight = this.weight,
    weaknesses = this.weaknesses
)

