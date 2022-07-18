package br.com.cwi.hearthstonecards.presentation.feature.listedCustomCards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.hearthstonecards.data.database.entity.CustomCardEntity
import br.com.cwi.hearthstonecards.domain.entity.CustomCard
import br.com.cwi.hearthstonecards.domain.repository.HearthstoneLocalRepository
import br.com.cwi.hearthstonecards.presentation.base.BaseViewModel

class ListedCustomCardViewModel (private val repository: HearthstoneLocalRepository) : BaseViewModel() {
    private val _customCards = MutableLiveData<List<CustomCard>?>()
    val customCards: LiveData<List<CustomCard>?> = _customCards

    fun fetchCustomCards() {
        launch {
            val cards = repository.getAllCustomCards()
            _customCards.postValue(cards)
        }
    }
}