package br.com.cwi.hearthstonecards.presentation.feature.card

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.hearthstonecards.databinding.ItemListedCardBinding
import br.com.cwi.hearthstonecards.domain.entity.Card
import androidx.core.content.ContextCompat.startActivity
import br.com.cwi.hearthstonecards.presentation.feature.cardDetails.CardDetailsActivity

class CardViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val contentListedCards = ItemListedCardBinding.bind(item).contentListedCard
    private val tvCardName = ItemListedCardBinding.bind(item).tvCardName

    fun bind(context: Context, card: Card) {
        tvCardName.text = card.name ?: "No Name Available"

        with(contentListedCards) {
            setOnClickListener {
                val intent = Intent(context, CardDetailsActivity::class.java)
                    .putExtra("cardName", tvCardName.text)
                    .putExtra("cardImg", card.img)
                    .putExtra("cardFlavour", card.flavor ?: "No Additional Text Available")
                startActivity(context, intent, null)
            }
        }
    }
}