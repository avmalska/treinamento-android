package br.com.cwi.hearthstonecards.data.network.entity

import com.squareup.moshi.Json

class CardMechanicsResponse(
    @Json(name = "name") val name: String
)