package br.com.cwi.hearthstonecards.presentation.feature.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.hearthstonecards.domain.entity.Info
import br.com.cwi.hearthstonecards.domain.repository.HearthstoneRepository
import br.com.cwi.hearthstonecards.presentation.base.BaseViewModel

class CategoriesViewModel(private val repository: HearthstoneRepository): BaseViewModel() {

    private val _info = MutableLiveData<Info>()
    val info: LiveData<Info> = _info

    fun fetchInfos() {
        launch {
            val allInfos = repository.getInfos()
            _info.postValue(allInfos)
        }
    }
}