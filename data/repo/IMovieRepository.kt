package com.lomu.irepository

import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData
import com.lomu.model.MovieSearch
import java.util.concurrent.Flow

interface IMovieRepository {

    fun onSearch(
        key: String,
        language: String = "en",
    ) : Flow<PagingData<MovieSearch>>

    suspend fun getMovieDetails(

    )
}