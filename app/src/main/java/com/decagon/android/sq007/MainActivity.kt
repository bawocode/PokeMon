package com.decagon.android.sq007

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decagon.android.sq007.clickListener.DataReady
import com.decagon.android.sq007.clickListener.ItemClickListener
import com.decagon.android.sq007.pokemonApi.Result
import com.decagon.android.sq007.recyclerviewadapter.PokemonAdapter
import common.Common
import common.ItemOffSetDecoration
import services.ApiService

class MainActivity : AppCompatActivity(), ItemClickListener, DataReady {

    private lateinit var pokemonRecyclerview: RecyclerView
    private lateinit var pokemonList: List<Result>
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pokemonRecyclerview = findViewById(R.id.pokemon_recyclerview)
        pokemonList = ArrayList()

        pokemonRecyclerview.layoutManager = GridLayoutManager(this, 2)
        val itemDecoration = ItemOffSetDecoration(this, R.dimen.spacing)
        pokemonRecyclerview.addItemDecoration(itemDecoration)

        setRecyclerViewAdapter()
        ApiService.fetchPokeMonList(this)
    }
    private fun setRecyclerViewAdapter() {

        Log.i("emma", "$pokemonList")
        adapter = PokemonAdapter(this, pokemonList, this)
        pokemonRecyclerview.adapter = adapter
    }

    override fun onClick(imagePosition: Int) {

        Common.imagePosition = "$imagePosition"
        ApiService.fetchPokeMonDetails("$imagePosition", this)
    }

    override fun onDataDetailsSuccess() {
        Log.i("PokemonDetails", "$Common.abilities")
        startActivity(Intent(this, PokemonDetailsActivity::class.java))
    }

    override fun onDataDetailsFailure() {
    }

    override fun onPokemonListSuccess(pokemonList: List<Result>) {
        pokemonRecyclerview.adapter = PokemonAdapter(this, pokemonList, this)
    }

    override fun onPokemonListFailure() {
    }
}
