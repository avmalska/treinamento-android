package br.com.cwi.hearthstonecards.presentation.feature.categories

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.hearthstonecards.R

class CategoriesAdapter(val context: Context, private val list: List<String>) :
    RecyclerView.Adapter<CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_category, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val item = list[position]
        holder.bind(context, item)
    }

    override fun getItemCount() = list.size
}