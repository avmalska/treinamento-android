package br.com.cwi.nespresso_app.data.entity

import com.squareup.moshi.Json

class CategoryAccessoryResponse(
    @Json(name = "categoria") val category: String,
    @Json(name = "itens") val accessories: List<AccessoryResponse>
)