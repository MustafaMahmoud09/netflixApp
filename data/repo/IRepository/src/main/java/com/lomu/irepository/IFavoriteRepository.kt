package com.lomu.irepository

import com.lomu.model.MovieFavorite
import kotlinx.coroutines.flow.Flow

interface IFavoriteRepository {

    fun getMovieById(
        id: String
    ): List<MovieFavorite>

    suspend fun insertFavoriteMovie(
        movieFavorite: MovieFavorite
    )

    suspend fun removeFavoriteMovie(
        id: String
    )

    fun getFavoriteMovies(): Flow<List<MovieFavorite>>

}