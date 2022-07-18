package br.com.cwi.hearthstonecards.data.network.mapper

import br.com.cwi.hearthstonecards.data.network.entity.CardMechanicsResponse
import br.com.cwi.hearthstonecards.data.network.entity.CardResponse
import br.com.cwi.hearthstonecards.domain.entity.Card

class CardMapper: DomainMapper<CardResponse, Card> {

    override fun toDomain(from: List<CardResponse>) = from.map {
        toDomain(it)
    }

    override fun toDomain(from: CardResponse) = Card (
        id = from.id,
        dbfId = from?.dbfId,
        name = from?.name,
        set = from?.set,
        type = from?.type,
        faction = from?.faction,
        rarity = from?.rarity,
        cost = from?.cost,
        attack = from?.attack,
        health = from?.health,
        text = from?.text,
        flavor = from?.flavor,
        artist = from?.artist,
        collectible = from?.collectible,
        elite = from?.elite,
        race = from?.race,
        img = from?.img,
        imgGold = from?.imgGold,
        locale = from?.locale,
        playerClass = from?.playerClass,
        mechanics = from.mechanics?.let { CardMechanicsMapper().toDomain(it) },
        spellSchool = from?.spellSchool,
        howToGet = from?.howToGet,
        howToGetGold = from?.howToGetGold
    )
}