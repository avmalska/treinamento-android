package br.com.cwi.hearthstonecards.presentation.feature.createCustomCard

import br.com.cwi.hearthstonecards.data.database.mapper.toEntity
import br.com.cwi.hearthstonecards.domain.entity.CustomCard
import br.com.cwi.hearthstonecards.domain.repository.HearthstoneLocalRepository
import br.com.cwi.hearthstonecards.presentation.base.BaseViewModel

class CreateCustomCardViewModel(private val repository: HearthstoneLocalRepository): BaseViewModel() {

    fun saveCardToLocalStorage(customCard: CustomCard) {
        repository.addCustomCard(customCard.toEntity())
    }
}