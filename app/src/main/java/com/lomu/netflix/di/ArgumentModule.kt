package com.lomu.netflix.di

import com.lomu.uielement.navGraph.MovieArg
import com.lomu.usecase.set.SetMovieFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArgumentModule {

    @Provides
    @Singleton
    @Named("movie_id")
    fun provideMovieId():String{

        return MovieArg.MOVIE_ID
    }

}