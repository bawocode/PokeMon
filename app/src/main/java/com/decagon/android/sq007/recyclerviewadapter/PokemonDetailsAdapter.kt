package com.decagon.android.sq007.recyclerviewadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.decagon.android.sq007.R
import com.decagon.android.sq007.pokemonApi.Ability
import com.decagon.android.sq007.pokemonApi.Move
import com.decagon.android.sq007.pokemonApi.Stat
import common.Common

class PokemonDetailsAdapter<T>(var details: List<T>, var context: Context) : RecyclerView.Adapter<PokemonDetailsAdapter<T>.DetailViewHolder>() {

    inner class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var abilityTextView: TextView
        var moveTextView: TextView
        var statTextView: TextView

        init {

            abilityTextView = itemView.findViewById(R.id.textView)

            moveTextView = itemView.findViewById(R.id.textView)

            statTextView = itemView.findViewById(R.id.textView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.details_layout, parent, false)

        return DetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return details.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {

        if (details[0] is Ability) {
            holder.itemView.apply {

                holder?.abilityTextView.text = Common.abilities?.get(position)?.ability?.name
            }
        }
        if (details[0] is Move) {
            holder.itemView.apply {

                holder?.moveTextView.text = Common.move?.get(position)?.move?.name
            }
        }

        if (details[0] is Stat) {
            holder.itemView.apply {

                holder?.statTextView.text = Common.stats?.get(position)?.stat?.name
            }
        }
    }
}
