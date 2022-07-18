package br.com.cwi.hearthstonecards.data.network.mapper

import br.com.cwi.hearthstonecards.data.network.entity.CardMechanicsResponse
import br.com.cwi.hearthstonecards.domain.entity.CardMechanic

class CardMechanicsMapper : DomainMapper<CardMechanicsResponse, CardMechanic> {
    override fun toDomain(from: CardMechanicsResponse) = CardMechanic(
        name = from.name
    )

    override fun toDomain(from: List<CardMechanicsResponse>) = from.map {
        toDomain(it)
    }
}