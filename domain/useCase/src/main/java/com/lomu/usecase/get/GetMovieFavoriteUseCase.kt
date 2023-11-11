package com.lomu.usecase.get

import com.lomu.irepository.IFavoriteRepository
import com.lomu.model.MovieFavorite
import kotlinx.coroutines.flow.Flow

class GetMovieFavoriteUseCase(
    private val favoriteRepository: IFavoriteRepository
) {

    operator fun invoke(): Flow<List<MovieFavorite>> {

        return favoriteRepository.getFavoriteMovies()
    }
}