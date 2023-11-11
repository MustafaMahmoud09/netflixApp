package com.lomu.netflix.di

import com.lomu.usecase.set.SetMovieFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.lomu.irepository.IFavoriteRepository

@Module
@InstallIn(SingletonComponent::class)
object UseCaseCompleteModule {

    @Provides
    @Singleton
    fun provideCheckMovieUseCase(
        favoriteRepository: IFavoriteRepository,
    ): SetMovieFavoriteUseCase {

        return SetMovieFavoriteUseCase(
            favoriteRepository = favoriteRepository
        )
    }

}