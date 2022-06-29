package br.com.cwi.nespresso_app.domain.repository

import br.com.cwi.nespresso_app.domain.entity.Category
import br.com.cwi.nespresso_app.domain.entity.Machine

interface CoffeeRepository {
    suspend fun getCoffees(): List<Category>
    suspend fun getMachines(): List<Machine>
    suspend fun getAccessories(): List<Category>
    suspend fun getMachineInfo(id: Int): Machine?
}