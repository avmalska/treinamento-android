package br.com.cwi.hearthstonecards.presentation.feature.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.hearthstonecards.domain.entity.Card
import br.com.cwi.hearthstonecards.domain.repository.HearthstoneRepository
import br.com.cwi.hearthstonecards.presentation.base.BaseViewModel

class CardViewModel (private val repository: HearthstoneRepository) : BaseViewModel() {
    private val _cards = MutableLiveData<List<Card>>()
    val cards: LiveData<List<Card>> = _cards

    fun fetchCards(subcategoryName: String, categoryName:String) {
        launch {
            val listedCards = repository.getCardsBySubCategory(categoryName, subcategoryName)
            _cards.postValue(listedCards)
        }
    }
}