package com.lomu.irepository

import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData
import com.lomu.model.MovieSearch
import com.lomu.model.Movie
import com.lomu.model.MovieHome
import com.lomu.model.MovieCast

interface IMovieRepository {

    fun onSearch(
        key: String,
        language: String = "en",
    ) : Flow<PagingData<MovieSearch>>

    fun getMovieDetails(
        id : String
    ) : Flow<PagingData<Movie>>

    fun getMovieCast(
        id : String
    ): Flow<PagingData<MovieCast>>

    fun getMoviesUpcoming(
        language: String
    ): Flow<PagingData<MovieHome>>

    fun getMoviesNowPlaying(
        language: String
    ): Flow<PagingData<MovieHome>>

    fun getMoviesPopular(
        language: String
    ): Flow<PagingData<MovieHome>>

    fun getMoviesLastWeek(
        language: String
    ): Flow<PagingData<MovieHome>>

    fun getMoviesTopRated(
        language: String
    ): Flow<PagingData<MovieHome>>

}