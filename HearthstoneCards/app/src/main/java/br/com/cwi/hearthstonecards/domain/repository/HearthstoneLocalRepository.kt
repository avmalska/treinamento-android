package br.com.cwi.hearthstonecards.domain.repository

import br.com.cwi.hearthstonecards.data.database.entity.CustomCardEntity
import br.com.cwi.hearthstonecards.domain.entity.CustomCard

interface HearthstoneLocalRepository {
    fun addCustomCard(customCardEntity: CustomCardEntity)
    fun getAllCustomCards(): List<CustomCard>?
}