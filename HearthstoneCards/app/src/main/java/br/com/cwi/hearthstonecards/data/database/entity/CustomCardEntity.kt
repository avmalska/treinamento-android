package br.com.cwi.hearthstonecards.data.database.entity

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CustomCardEntity (

    @PrimaryKey val id: Int,
    val cardName: String,
    val cardImage: ByteArray
)