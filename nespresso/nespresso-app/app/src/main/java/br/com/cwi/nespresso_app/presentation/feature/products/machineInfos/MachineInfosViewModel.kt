package br.com.cwi.nespresso_app.presentation.feature.products.machineInfos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.domain.entity.Machine
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel

class MachineInfosViewModel(private val repository: CoffeeRepository): BaseViewModel() {

    private val _machine = MutableLiveData<Machine>()
    val machine: LiveData<Machine> = _machine

    fun fetchMachineInfos(machineId: Int) {
        launch {
            val selectedMachine = repository.getMachineInfo(machineId)
            _machine.postValue(selectedMachine)
        }
    }
}