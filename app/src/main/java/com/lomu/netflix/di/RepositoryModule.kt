package com.lomu.netflix.di

import com.lomu.api.endPoint.MovieApi
import com.lomu.irepository.IFavoriteRepository
import com.lomu.irepository.IMovieRepository
import com.lomu.mapper.Group.*
import com.lomu.mapper.One.MappingMovieFavoriteFromModelToEntity
import com.lomu.mapper.One.MappingSingleMovieFromDtoToModel
import com.lomu.repository.repository.FavoriteRepository
import com.lomu.repository.repository.MovieRepository
import com.lomu.room.NetflixDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideFavoriteRepository(
        roomDatabase: NetflixDatabase,
        mappingMovieFavoriteFromEntityToModel : MappingMovieFavoriteFromEntityToModel,
        mappingMovieFavoriteFromModelToEntity: MappingMovieFavoriteFromModelToEntity
    ): IFavoriteRepository {

        return FavoriteRepository(
            roomDatabase = roomDatabase,
            mappingMovieFavoriteFromEntityToModel = mappingMovieFavoriteFromEntityToModel,
            mappingMovieFavoriteFromModelToEntity = mappingMovieFavoriteFromModelToEntity
        )
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        roomDatabase: NetflixDatabase,
        movieApi: MovieApi,
        mappingMovieSearchFromDtoToModel: MappingMovieSearchFromDtoToModel,
        mappingSingleMovieFromDtoToModel: MappingSingleMovieFromDtoToModel,
        mappingMovieCastFromDtoToModel: MappingMovieCastFromDtoToModel,
        mappingMovieHomeFromDtoToModel: MappingMovieHomeFromDtoToModel,
        mappingMovieHomeHeaderFromDtoToModel: MappingMovieHomeHeaderFromDtoToModel
    ): IMovieRepository {

        return MovieRepository(
            roomDatabase = roomDatabase,
            movieApi = movieApi,
            mappingMovieSearchFromDtoToModel = mappingMovieSearchFromDtoToModel,
            mappingSingleMovieFromDtoToModel = mappingSingleMovieFromDtoToModel,
            mappingMovieCastFromDtoToModel = mappingMovieCastFromDtoToModel,
            mappingMovieHomeFromDtoToModel = mappingMovieHomeFromDtoToModel,
            mappingMovieHomeHeaderFromDtoToModel = mappingMovieHomeHeaderFromDtoToModel
        )
    }
}