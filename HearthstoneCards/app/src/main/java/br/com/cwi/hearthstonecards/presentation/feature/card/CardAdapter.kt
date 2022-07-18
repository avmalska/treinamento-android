package br.com.cwi.hearthstonecards.presentation.feature.card

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.hearthstonecards.R
import br.com.cwi.hearthstonecards.domain.entity.Card

class CardAdapter(val context: Context, private val cardsList: List<Card>) :
    RecyclerView.Adapter<CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_listed_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = cardsList[position]
        holder.bind(context, item)
    }

    override fun getItemCount() = cardsList.size
}