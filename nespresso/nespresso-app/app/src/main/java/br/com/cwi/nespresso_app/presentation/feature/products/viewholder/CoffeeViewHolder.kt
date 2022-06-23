package br.com.cwi.nespresso_app.presentation.feature.products.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ItemCoffeeBinding
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import com.bumptech.glide.Glide

class CoffeeViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val tvTitle = ItemCoffeeBinding.bind(item).tvTitle
    private val tvSubtitle = ItemCoffeeBinding.bind(item).tvSubtitle
    private val ivImage = ItemCoffeeBinding.bind(item).ivImage
    private val tvIntensity = ItemCoffeeBinding.bind(item).tvIntensity
    private val tvPrice = ItemCoffeeBinding.bind(item).tvPrice
    private val ivFavorite = ItemCoffeeBinding.bind(item).ivFavorite

    fun bind(context: Context, item: Coffee) {
        tvTitle.text = item.name
        tvSubtitle.text = item.description
        tvIntensity.text = context.getString(R.string.txt_intensity, item.intensity)
        tvPrice.text = item.unitPrice.toMoneyFormat()

        Glide.with(context)
            .load(item.urlImage)
            .into(ivImage)
    }
}