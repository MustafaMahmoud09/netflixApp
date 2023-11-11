package com.lomu.usecase.check

import com.lomu.irepository.IFavoriteRepository

class CheckMovieUseCase(
    private val favoriteRepository: IFavoriteRepository
) {
    operator fun invoke(
        id : String
    ): Boolean{

        return !favoriteRepository.getMovieById(id).isEmpty()
    }
}