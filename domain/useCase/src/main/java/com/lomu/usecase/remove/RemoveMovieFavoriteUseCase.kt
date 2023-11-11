package com.lomu.usecase.remove

import com.lomu.irepository.IFavoriteRepository

class RemoveMovieFavoriteUseCase(
    private val favoriteRepository: IFavoriteRepository
) {

    suspend operator fun invoke(id: String) {

        favoriteRepository.removeFavoriteMovie(
            id = id
        )
    }
}