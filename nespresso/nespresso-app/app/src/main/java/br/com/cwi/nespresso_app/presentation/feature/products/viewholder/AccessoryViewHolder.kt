package br.com.cwi.nespresso_app.presentation.feature.products.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.databinding.ItemAccessoryBinding
import br.com.cwi.nespresso_app.domain.entity.Accessory
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import com.bumptech.glide.Glide

class AccessoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val tvTitle = ItemAccessoryBinding.bind(item).tvTitle
    private val ivImage = ItemAccessoryBinding.bind(item).ivImage
    private val tvPrice = ItemAccessoryBinding.bind(item).tvPrice
    private val ivFavorite = ItemAccessoryBinding.bind(item).ivFavorite

    fun bind(context: Context, item: Accessory) {
        tvTitle.text = item.name
        tvPrice.text = item.unitPrice.toMoneyFormat()

        Glide.with(context)
            .load(item.urlImage)
            .into(ivImage)
    }
}