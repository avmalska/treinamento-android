package br.com.cwi.hearthstonecards.data.repository

import br.com.cwi.hearthstonecards.data.network.HearthstoneApi
import br.com.cwi.hearthstonecards.data.network.mapper.CardMapper
import br.com.cwi.hearthstonecards.data.network.mapper.InfoMapper
import br.com.cwi.hearthstonecards.domain.entity.Card
import br.com.cwi.hearthstonecards.domain.entity.Info
import br.com.cwi.hearthstonecards.domain.repository.HearthstoneRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HearthstoneRepositoryImpl (
    private val api: HearthstoneApi,
    private val infoMapper: InfoMapper,
    private val cardMapper: CardMapper
    ) : HearthstoneRepository {


    override suspend fun getInfos(): Info {
        return withContext(Dispatchers.IO) {
            infoMapper.toDomain(api.getInfos())
        }
    }

    override suspend fun getCardsBySubCategory(category: String, subcategory: String): List<Card> {
        return withContext(Dispatchers.IO) {
            cardMapper.toDomain(api.getCardsBySubCategory(category, subcategory))
        }
    }

}