package com.lomu.usecase.get

import androidx.paging.PagingData
import com.lomu.model.MovieHome
import kotlinx.coroutines.flow.Flow
import com.lomu.irepository.IMovieRepository

class GetMoviesTopRatedUseCase(
    private val movieRepository: IMovieRepository,
) {

    operator fun invoke(
        language: String
    ): Flow<PagingData<MovieHome>> {

        return movieRepository.getMoviesTopRated(
            language = language
        )
    }
}