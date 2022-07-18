package br.com.cwi.hearthstonecards.di

import br.com.cwi.hearthstonecards.presentation.feature.card.CardViewModel
import br.com.cwi.hearthstonecards.presentation.feature.categories.CategoriesViewModel
import br.com.cwi.hearthstonecards.presentation.feature.createCustomCard.CreateCustomCardViewModel
import br.com.cwi.hearthstonecards.presentation.feature.listedCustomCards.ListedCustomCardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CategoriesViewModel(get()) }
    viewModel { CardViewModel(get()) }
    viewModel { CreateCustomCardViewModel(get()) }
    viewModel { ListedCustomCardViewModel(get()) }
}