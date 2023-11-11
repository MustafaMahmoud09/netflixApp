package com.lomu.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "movie_favorite"
)
data class MovieFavoriteEntity(
    @PrimaryKey val id: String,
    val path : String,
    val title : String,
    val vote : Double
)
