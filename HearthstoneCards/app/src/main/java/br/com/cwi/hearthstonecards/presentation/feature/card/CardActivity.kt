package br.com.cwi.hearthstonecards.presentation.feature.card

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.cwi.hearthstonecards.R
import br.com.cwi.hearthstonecards.databinding.ActivityListedCardsBinding
import br.com.cwi.hearthstonecards.domain.entity.Card
import br.com.cwi.hearthstonecards.presentation.base.BaseBottomNavigation
import br.com.cwi.hearthstonecards.presentation.extension.visibleOrGone
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityListedCardsBinding

    private val viewModel: CardViewModel by viewModel()

    override val currentTab: Int = R.id.home_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListedCardsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel.cards.observe(this@CardActivity) { cardsList ->
            setUpAdapter(cardsList)
        }

        viewModel.loading.observe(this@CardActivity) { isLoading ->
            binding.viewLoading.root.visibleOrGone(isLoading)
        }

        viewModel.error.observe(this@CardActivity) { hasError ->
            binding.viewError.root.visibleOrGone(hasError)
        }

        val categoryName = intent.getStringExtra("categoryName")
        intent.getStringExtra("subcategoryName")?.let { viewModel.fetchCards(it, categoryName!!) }
    }

    private fun setUpAdapter(cards: List<Card>) {
        binding.rvCards.apply {
            adapter = CardAdapter(context = context, cards)
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root
}