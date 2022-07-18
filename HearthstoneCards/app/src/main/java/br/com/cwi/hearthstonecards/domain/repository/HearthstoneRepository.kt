package br.com.cwi.hearthstonecards.domain.repository

import br.com.cwi.hearthstonecards.domain.entity.Card
import br.com.cwi.hearthstonecards.domain.entity.Info

interface HearthstoneRepository {
    suspend fun getInfos(): Info
    suspend fun getCardsBySubCategory(category: String, subcategory: String): List<Card>
}