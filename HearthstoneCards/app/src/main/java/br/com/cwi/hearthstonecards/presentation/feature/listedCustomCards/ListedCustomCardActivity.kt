package br.com.cwi.hearthstonecards.presentation.feature.listedCustomCards

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.cwi.hearthstonecards.R
import br.com.cwi.hearthstonecards.databinding.ActivityListedCustomCardsBinding
import br.com.cwi.hearthstonecards.domain.entity.CustomCard
import br.com.cwi.hearthstonecards.presentation.base.BaseBottomNavigation
import br.com.cwi.hearthstonecards.presentation.extension.visibleOrGone
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListedCustomCardActivity : BaseBottomNavigation() {
    private lateinit var binding: ActivityListedCustomCardsBinding

    private val viewModel: ListedCustomCardViewModel by viewModel()

    override val currentTab: Int = R.id.customcards_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListedCustomCardsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel.customCards.observe(this@ListedCustomCardActivity) { listCustomCards ->
            setUpAdapter(listCustomCards)
        }

        viewModel.loading.observe(this@ListedCustomCardActivity) { isLoading ->
            binding.viewLoading.root.visibleOrGone(isLoading)
        }

        viewModel.error.observe(this@ListedCustomCardActivity) { hasError ->
            binding.viewError.root.visibleOrGone(hasError)
        }

        viewModel.fetchCustomCards()
    }

    private fun setUpAdapter(listCustomCards: List<CustomCard>?) {
        binding.rvCustomCards.apply {
            adapter = listCustomCards?.let { ListedCustomCardAdapter(context = context, it) }
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root
}