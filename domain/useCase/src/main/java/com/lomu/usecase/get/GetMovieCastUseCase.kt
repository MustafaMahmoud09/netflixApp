package com.lomu.usecase.get

import androidx.paging.PagingData
import com.lomu.irepository.IMovieRepository
import com.lomu.model.MovieCast
import kotlinx.coroutines.flow.Flow

class GetMovieCastUseCase(
    private val movieRepository: IMovieRepository,
) {

    operator fun invoke(
        id: String
    ): Flow<PagingData<MovieCast>>{

        return movieRepository.getMovieCast(
            id = id
        )
    }
}