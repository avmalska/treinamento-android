package br.com.cwi.hearthstonecards.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.cwi.hearthstonecards.data.database.dao.HearthstoneDao
import br.com.cwi.hearthstonecards.data.database.entity.CustomCardEntity

@Database(entities = [CustomCardEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getHearthstoneDao(): HearthstoneDao

    companion object {
        private const val DATABASE_NAME = "hearthstone-db"
        fun create(application: Application): AppDatabase {
            return Room.databaseBuilder(
                application,
                AppDatabase::class.java,
                DATABASE_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}