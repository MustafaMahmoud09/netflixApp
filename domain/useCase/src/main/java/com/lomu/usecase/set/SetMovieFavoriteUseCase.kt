package com.lomu.usecase.set

import com.lomu.irepository.IFavoriteRepository
import com.lomu.model.MovieFavorite

class SetMovieFavoriteUseCase(
    private val favoriteRepository: IFavoriteRepository
) {

    suspend operator fun invoke(
        movieFavorite: MovieFavorite
    ) {

        favoriteRepository.insertFavoriteMovie(
            movieFavorite = movieFavorite
        )
    }
}