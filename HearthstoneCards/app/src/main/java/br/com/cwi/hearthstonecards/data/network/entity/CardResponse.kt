package br.com.cwi.hearthstonecards.data.network.entity

import com.squareup.moshi.Json

class CardResponse (
    @Json(name = "cardId") val id: String,
    @Json(name = "dbfId") val dbfId: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "cardSet") val set: String?,
    @Json(name = "type") val type: String?,
    @Json(name = "faction") val faction: String?,
    @Json(name = "rarity") val rarity: String?,
    @Json(name = "cost") val cost: Int?,
    @Json(name = "attack") val attack: Int?,
    @Json(name = "health") val health: Int?,
    @Json(name = "text") val text: String?,
    @Json(name = "flavor") val flavor: String?,
    @Json(name = "artist") val artist: String?,
    @Json(name = "collectible") val collectible: Boolean?,
    @Json(name = "elite") val elite: Boolean?,
    @Json(name = "race") val race: String?,
    @Json(name = "img") val img: String?,
    @Json(name = "imgGold") val imgGold: String?,
    @Json(name = "locale") val locale: String?,
    @Json(name = "playerClass") val playerClass: String?,
    @Json(name = "mechanics") val mechanics: List<CardMechanicsResponse>?,
    @Json(name = "spellSchool") val spellSchool: String?,
    @Json(name = "howToGet") val howToGet: String?,
    @Json(name = "howToGetGold") val howToGetGold: String?
)