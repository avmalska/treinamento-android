package br.com.cwi.hearthstonecards.presentation.feature.listedCustomCards

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.hearthstonecards.R
import br.com.cwi.hearthstonecards.domain.entity.CustomCard

class ListedCustomCardAdapter(val context: Context, private val listCustomCard: List<CustomCard>) :
RecyclerView.Adapter<ListedCustomCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListedCustomCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_listed_card, parent, false)
        return ListedCustomCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListedCustomCardViewHolder, position: Int) {
        val item = listCustomCard[position]
        holder.bind(context, item)
    }

    override fun getItemCount() = listCustomCard.size
}