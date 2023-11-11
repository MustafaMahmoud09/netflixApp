package com.lomu.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lomu.entity.MovieFavoriteEntity

@Database(
    entities = [
        MovieFavoriteEntity::class
    ],
    version = 1
)
abstract class NetflixDatabase : RoomDatabase() {

    abstract fun netflixDao(): NetflixDao
}