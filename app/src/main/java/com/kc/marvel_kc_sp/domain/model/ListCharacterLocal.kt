package com.kc.marvel_kc_sp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "marvel_characters")
data class ListCharacterLocal (
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "thumbnail") val thumbnail: Thumbnail,
    @ColumnInfo(name = "favorite") val favorite: Boolean,
    @ColumnInfo(name = "position") val position: Int,
)