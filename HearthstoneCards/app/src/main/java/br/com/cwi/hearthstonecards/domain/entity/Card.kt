package br.com.cwi.hearthstonecards.domain.entity

import br.com.cwi.hearthstonecards.data.network.entity.CardMechanicsResponse
import com.squareup.moshi.Json

class Card (
    val id: String,
    val dbfId: String?,
    val name: String?,
    val set: String?,
    val type: String?,
    val faction: String?,
    val rarity: String?,
    val cost: Int?,
    val attack: Int?,
    val health: Int?,
    val text: String?,
    val flavor: String?,
    val artist: String?,
    val collectible: Boolean?,
    val elite: Boolean?,
    val race: String?,
    val img: String?,
    val imgGold: String?,
    val locale: String?,
    val playerClass: String?,
    val mechanics: List<CardMechanic>?,
    val spellSchool: String?,
    val howToGet: String?,
    val howToGetGold: String?
)