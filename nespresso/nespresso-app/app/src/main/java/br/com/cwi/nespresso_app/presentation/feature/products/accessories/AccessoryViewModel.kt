package br.com.cwi.nespresso_app.presentation.feature.products.accessories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.data.mapper.CategoryAccessoryMapper
import br.com.cwi.nespresso_app.data.mapper.CategoryCoffeeMapper
import br.com.cwi.nespresso_app.data.mapper.MachineMapper
import br.com.cwi.nespresso_app.data.repository.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.domain.entity.Category
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel

class AccessoryViewModel(
    private val repository: CoffeeRepository
): BaseViewModel() {

    private val _accessories = MutableLiveData<List<Type>>()
    val accessories: LiveData<List<Type>> = _accessories

    fun fetchAccessories() {
        launch {
            val categoryList = repository.getAccessories()
            _accessories.postValue(getTypeList(categoryList))
        }
    }

    private fun getTypeList(categoryList: List<Category>): List<Type> {
        val typeList = mutableListOf<Type>()

        categoryList.forEach {
            typeList.add(it)
            typeList.addAll(it.products)
        }
        return typeList
    }

}