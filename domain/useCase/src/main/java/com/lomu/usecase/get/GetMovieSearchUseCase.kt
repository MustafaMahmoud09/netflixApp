package com.lomu.usecase.get

import androidx.paging.PagingData
import com.lomu.irepository.IMovieRepository
import com.lomu.model.MovieSearch
import kotlinx.coroutines.flow.Flow

class GetMovieSearchUseCase(
    private val movieRepository: IMovieRepository,
) {

    operator fun invoke(
        key: String,
        language: String = "en",
    ): Flow<PagingData<MovieSearch>> {

        return movieRepository.onSearch(
            key = key,
            language = language,
        )
    }
}