package br.com.cwi.nespresso_app.data.network

import br.com.cwi.nespresso_app.data.entity.CategoryAccessoryResponse
import br.com.cwi.nespresso_app.data.entity.CategoryCoffeeResponse
import br.com.cwi.nespresso_app.data.entity.MachineResponse
import retrofit2.http.GET

interface NespressoApi {

    @GET("/capsulas")
    suspend fun getCoffees(): List<CategoryCoffeeResponse>

    @GET("/maquinas")
    suspend fun getMachines(): List<MachineResponse>

    @GET("/acessorios")
    suspend fun getAccessories(): List<CategoryAccessoryResponse>
}