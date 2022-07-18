package br.com.cwi.hearthstonecards.presentation.feature.categories

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.hearthstonecards.databinding.ItemCardCategoryBinding

class CategoriesViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val contentCardCategory = ItemCardCategoryBinding.bind(item).contentCardCategory
    private val tvCategoryName = ItemCardCategoryBinding.bind(item).tvCategoryName

    fun bind(context: Context, categoryName: String) {
        tvCategoryName.text = categoryName

    }
}
