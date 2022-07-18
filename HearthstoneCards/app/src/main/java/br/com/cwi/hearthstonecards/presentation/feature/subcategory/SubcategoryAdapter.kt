package br.com.cwi.hearthstonecards.presentation.feature.subcategory

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.hearthstonecards.R

class SubcategoryAdapter(val context: Context, private val list: List<String>, private val categoryName: String) :
    RecyclerView.Adapter<SubcategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubcategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_category, parent, false)
        return SubcategoryViewHolder(view, categoryName)
    }

    override fun onBindViewHolder(holder: SubcategoryViewHolder, position: Int) {
        val item = list[position]
        holder.bind(context, item)
    }

    override fun getItemCount() = list.size
}