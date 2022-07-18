package br.com.cwi.hearthstonecards.data.repository

import br.com.cwi.hearthstonecards.data.database.AppDatabase
import br.com.cwi.hearthstonecards.data.database.entity.CustomCardEntity
import br.com.cwi.hearthstonecards.data.database.mapper.toCustomCard
import br.com.cwi.hearthstonecards.domain.entity.CustomCard
import br.com.cwi.hearthstonecards.domain.repository.HearthstoneLocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HearthstoneLocalRepositoryImpl(
    appDatabase: AppDatabase
) : HearthstoneLocalRepository {

    private val dao = appDatabase.getHearthstoneDao()

    override fun addCustomCard(customCardEntity: CustomCardEntity) {
        dao.addCustomCard(customCardEntity)
    }

    override fun getAllCustomCards(): List<CustomCard>? {
        return dao.getAllCustomCards()?.map { customCard -> customCard.toCustomCard() }
    }

}