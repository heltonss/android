package com.heltonsilveira.pokeapi

import com.heltonsilveira.data.model.Pokemon


interface MainContract {
    interface MainView {
        fun mostrarPokemon(pokemon: Pokemon?)

    }

    interface MainPresenter
}