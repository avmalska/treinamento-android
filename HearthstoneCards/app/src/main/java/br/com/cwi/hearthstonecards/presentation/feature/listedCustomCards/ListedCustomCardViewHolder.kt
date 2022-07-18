package br.com.cwi.hearthstonecards.presentation.feature.listedCustomCards

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.hearthstonecards.databinding.ItemListedCardBinding
import br.com.cwi.hearthstonecards.domain.entity.CustomCard
import androidx.core.content.ContextCompat.startActivity
import br.com.cwi.hearthstonecards.presentation.feature.customCardDetails.CustomCardDetailsActivity

class ListedCustomCardViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val contentListedCard = ItemListedCardBinding.bind(item).contentListedCard
    private val tvCardName = ItemListedCardBinding.bind(item).tvCardName

    fun bind(context: Context, customCard: CustomCard) {
        tvCardName.text = customCard.cardName

        with(contentListedCard) {
            setOnClickListener {
                val intent = Intent(context, CustomCardDetailsActivity::class.java)
                    .putExtra("customCardName", tvCardName.text)
                    .putExtra("customCardImage", customCard.cardImage)
                startActivity(context, intent, null)
            }
        }
    }
}