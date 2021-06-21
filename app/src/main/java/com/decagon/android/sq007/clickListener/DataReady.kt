package com.decagon.android.sq007.clickListener

import com.decagon.android.sq007.pokemonApi.Result

interface DataReady {

    abstract fun onDataDetailsSuccess()
    abstract fun onDataDetailsFailure()
    abstract fun onPokemonListSuccess(pokemonList: List<Result>)
    abstract fun onPokemonListFailure()
}
