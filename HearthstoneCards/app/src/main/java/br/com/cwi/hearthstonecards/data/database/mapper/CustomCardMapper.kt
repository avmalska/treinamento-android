package br.com.cwi.hearthstonecards.data.database.mapper

import br.com.cwi.hearthstonecards.data.database.entity.CustomCardEntity
import br.com.cwi.hearthstonecards.domain.entity.CustomCard

fun CustomCardEntity.toCustomCard() = CustomCard(
    id, cardName, cardImage
)

fun CustomCard.toEntity() = CustomCardEntity(
    id, cardName, cardImage
)