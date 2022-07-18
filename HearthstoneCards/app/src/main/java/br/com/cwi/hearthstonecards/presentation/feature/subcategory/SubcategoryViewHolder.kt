package br.com.cwi.hearthstonecards.presentation.feature.subcategory

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.core.content.ContextCompat.startActivity
import br.com.cwi.hearthstonecards.databinding.ItemCardCategoryBinding
import br.com.cwi.hearthstonecards.presentation.feature.card.CardActivity

class SubcategoryViewHolder(item: View, categoryName: String) : RecyclerView.ViewHolder(item) {
    private val contentCardCategory = ItemCardCategoryBinding.bind(item).contentCardCategory
    private val tvCategoryName = ItemCardCategoryBinding.bind(item).tvCategoryName
    private val category = categoryName

    fun bind(context: Context, subcategoryName: String) {
        tvCategoryName.text = subcategoryName

        with(contentCardCategory) {
            setOnClickListener {
                val intent = Intent(context, CardActivity::class.java)
                    .putExtra("categoryName", category)
                    .putExtra("subcategoryName", subcategoryName)
                startActivity(context, intent, null)
            }
        }
    }
}