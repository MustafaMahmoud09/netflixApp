package com.lomu.usecase.get

import androidx.paging.PagingData
import com.lomu.irepository.IMovieRepository
import com.lomu.model.Movie
import kotlinx.coroutines.flow.Flow

class GetMovieUseCase(
    private val movieRepository: IMovieRepository,
) {

    operator fun invoke(
        id: String,
    ): Flow<PagingData<Movie>> {

        return movieRepository
            .getMovieDetails(
                id = id
            )
    }
}