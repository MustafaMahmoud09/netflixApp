package com.lomu.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lomu.entity.MovieFavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NetflixDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavoriteMovie(movie: MovieFavoriteEntity)

    @Query("SELECT * FROM movie_favorite")
    fun selectAllMovieFavorite(): Flow<List<MovieFavoriteEntity>>

    @Query("DELETE FROM movie_favorite WHERE id = :id")
    suspend fun deleteMovie(id: String)

    @Query("SELECT * FROM movie_favorite WHERE id = :id")
    fun getMovieById(id: String): List<MovieFavoriteEntity>

}