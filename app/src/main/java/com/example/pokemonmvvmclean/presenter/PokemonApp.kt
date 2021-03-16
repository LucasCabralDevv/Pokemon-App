package com.example.pokemonmvvmclean.presenter

import android.app.Application
import com.example.pokemonmvvmclean.presenter.di.pokemonServiceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PokemonApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PokemonApp)
            modules(pokemonServiceModule)
        }
    }
}