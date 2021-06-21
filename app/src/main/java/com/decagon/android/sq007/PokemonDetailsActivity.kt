package com.decagon.android.sq007

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.decagon.android.sq007.pokemonApi.Ability
import com.decagon.android.sq007.recyclerviewadapter.PokemonDetailsAdapter
import common.Common

class PokemonDetailsActivity : AppCompatActivity() {

    lateinit var recyclerViewDetailsAbilities: RecyclerView
    lateinit var recyclerViewDetailsMove: RecyclerView
    lateinit var recyclerViewDetailsStats: RecyclerView
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        recyclerViewDetailsAbilities =
            findViewById(R.id.pokemon_details_recyclerview_abilities)

        recyclerViewDetailsAbilities.apply {
            layoutManager = LinearLayoutManager(this@PokemonDetailsActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = PokemonDetailsAdapter<Ability>(Common.abilities!!, this@PokemonDetailsActivity)
        }

        recyclerViewDetailsMove = findViewById(R.id.pokemon_details_recyclerview_move)
        recyclerViewDetailsMove.apply {
            layoutManager = LinearLayoutManager(this@PokemonDetailsActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = PokemonDetailsAdapter(Common.move!!, this@PokemonDetailsActivity)
        }

        recyclerViewDetailsStats = findViewById(R.id.pokemon_details_recyclerview_stats)
        recyclerViewDetailsStats.apply {
            layoutManager = LinearLayoutManager(this@PokemonDetailsActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = PokemonDetailsAdapter(Common.stats!!, this@PokemonDetailsActivity)
        }

        imageView = findViewById(R.id.pokemon_details_image)
        Glide.with(applicationContext)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${Common.imagePosition }.png")
            .into(imageView)
    }
}
