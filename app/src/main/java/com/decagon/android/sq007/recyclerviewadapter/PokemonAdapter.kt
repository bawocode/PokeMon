package com.decagon.android.sq007.recyclerviewadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.decagon.android.sq007.R
import com.decagon.android.sq007.clickListener.ItemClickListener
import com.decagon.android.sq007.pokemonApi.Result

class PokemonAdapter(var context: Context, var pokemonList: List<Result>, var clickListener: ItemClickListener) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    inner class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var pokemonNameDisplay: TextView = view.findViewById(R.id.pokemon_name)
        var pokemonImage: ImageView = view.findViewById(R.id.pokemon_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_pokeman_list, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.itemView.apply {

            setOnClickListener { itemView ->
                clickListener.onClick(position + 1)
            }

            holder.pokemonNameDisplay.text = pokemonList[position].name
            Glide.with(context).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${position + 1}.png").into(holder.pokemonImage)
        }
    }
}
