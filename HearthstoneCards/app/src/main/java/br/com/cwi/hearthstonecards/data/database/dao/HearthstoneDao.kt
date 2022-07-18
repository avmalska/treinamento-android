package br.com.cwi.hearthstonecards.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.cwi.hearthstonecards.data.database.entity.CustomCardEntity


@Dao
interface HearthstoneDao {

    @Insert
    fun addCustomCard(customCardEntity: CustomCardEntity)

    @Query("SELECT * FROM CustomCardEntity")
    fun getAllCustomCards(): List<CustomCardEntity>?
}