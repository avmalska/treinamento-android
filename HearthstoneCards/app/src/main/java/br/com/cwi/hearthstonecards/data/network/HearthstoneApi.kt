package br.com.cwi.hearthstonecards.data.network

import br.com.cwi.hearthstonecards.data.network.entity.CardResponse
import br.com.cwi.hearthstonecards.data.network.entity.InfoResponse
import retrofit2.http.*

interface HearthstoneApi {

    @GET("/info")
    suspend fun getInfos(): InfoResponse

    @GET("/cards/{category}/{subcategory}")
    suspend fun getCardsBySubCategory(
        @Path("category") category: String,
        @Path("subcategory") subcategory: String
    ): List<CardResponse>
}