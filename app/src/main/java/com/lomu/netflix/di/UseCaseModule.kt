package com.lomu.netflix.di

import com.lomu.irepository.IFavoriteRepository
import com.lomu.irepository.IMovieRepository
import com.lomu.usecase.*
import com.lomu.usecase.check.CheckMovieUseCase
import com.lomu.usecase.get.*
import com.lomu.usecase.remove.RemoveMovieFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetMovieFavoriteUseCase(
        favoriteRepository: IFavoriteRepository,
    ): GetMovieFavoriteUseCase {

        return GetMovieFavoriteUseCase(
            favoriteRepository = favoriteRepository
        )
    }

    @Provides
    @Singleton
    fun provideRemoveMovieFavoriteUseCase(
        favoriteRepository: IFavoriteRepository,
    ): RemoveMovieFavoriteUseCase {

        return RemoveMovieFavoriteUseCase(
            favoriteRepository = favoriteRepository
        )
    }

    @Provides
    @Singleton
    fun provideGetMovieSearchUseCase(
        movieRepository: IMovieRepository
    ): GetMovieSearchUseCase {

        return GetMovieSearchUseCase(
            movieRepository = movieRepository
        )
    }

    @Provides
    @Singleton
    fun provideGetMovieUseCase(
        movieRepository: IMovieRepository
    ): GetMovieUseCase {

        return GetMovieUseCase(
            movieRepository = movieRepository
        )
    }

    @Provides
    @Singleton
    fun provideGetMovieCastUseCase(
        movieRepository: IMovieRepository
    ): GetMovieCastUseCase {

        return GetMovieCastUseCase(
            movieRepository = movieRepository
        )
    }

    @Provides
    @Singleton
    fun provideGetMoviesLastWeekUseCase(
        movieRepository: IMovieRepository
    ): GetMoviesLastWeekUseCase {

        return GetMoviesLastWeekUseCase(
            movieRepository = movieRepository
        )
    }

    @Provides
    @Singleton
    fun provideGetMovieUpcomingCase(
        movieRepository: IMovieRepository
    ): GetMovieUpcomingCase {

        return GetMovieUpcomingCase(
            movieRepository = movieRepository
        )
    }

    @Provides
    @Singleton
    fun provideGetMoviesPopularUseCase(
        movieRepository: IMovieRepository
    ): GetMoviesPopularUseCase {

        return GetMoviesPopularUseCase(
            movieRepository = movieRepository
        )
    }

    @Provides
    @Singleton
    fun provideGetMoviesTopRatedUseCase(
        movieRepository: IMovieRepository
    ): GetMoviesTopRatedUseCase {

        return GetMoviesTopRatedUseCase(
            movieRepository = movieRepository
        )
    }

    @Provides
    @Singleton
    fun provideGetMoviesNowPlayingUseCase(
        movieRepository: IMovieRepository
    ): GetMoviesNowPlayingUseCase {

        return GetMoviesNowPlayingUseCase(
            movieRepository = movieRepository
        )
    }

    @Provides
    @Singleton
    fun provideCheckMovieUseCase(
        favoriteRepository: IFavoriteRepository,
    ): CheckMovieUseCase {

        return CheckMovieUseCase(
            favoriteRepository = favoriteRepository
        )
    }

}