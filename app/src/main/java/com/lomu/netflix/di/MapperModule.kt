package com.lomu.netflix.di

import com.lomu.mapper.Group.*
import com.lomu.mapper.One.MappingMovieFavoriteFromModelToEntity
import com.lomu.mapper.One.MappingSingleMovieFromDtoToModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideMappingMovieSearchFromDtoToModel(
        @Named("imagePath") pathImage: String,
    ): MappingMovieSearchFromDtoToModel {

        return MappingMovieSearchFromDtoToModel(
            pathImage = pathImage
        )
    }

    @Provides
    @Singleton
    fun provideMappingSingleMovieFromDtoToModel(
        @Named("imagePath") pathImage: String,
    ): MappingSingleMovieFromDtoToModel {

        return MappingSingleMovieFromDtoToModel(
            imagePath = pathImage
        )
    }

    @Provides
    @Singleton
    fun provideMappingMovieCastFromDtoToModel(
        @Named("imagePath") pathImage: String
    ): MappingMovieCastFromDtoToModel {

        return MappingMovieCastFromDtoToModel(
            pathImage = pathImage
        )
    }

    @Provides
    @Singleton
    fun provideMappingMovieHomeFromDtoToModel(
        @Named("imagePath") pathImage: String
    ): MappingMovieHomeFromDtoToModel {

        return MappingMovieHomeFromDtoToModel(
            imagePath = pathImage
        )
    }

    @Provides
    @Singleton
    fun provideMappingMovieHomeHeaderFromDtoToModel(
        @Named("imagePath") pathImage: String
    ): MappingMovieHomeHeaderFromDtoToModel {

        return MappingMovieHomeHeaderFromDtoToModel(
            imagePath = pathImage
        )
    }

    @Provides
    @Singleton
    fun provideMappingMovieFavoriteFromEntityToModel(): MappingMovieFavoriteFromEntityToModel {

        return MappingMovieFavoriteFromEntityToModel()
    }

    @Provides
    @Singleton
    fun provideMappingMovieFavoriteFromModelToEntity(): MappingMovieFavoriteFromModelToEntity {

        return MappingMovieFavoriteFromModelToEntity()
    }

    @Provides
    @Singleton
    @Named("imagePath")
    fun provideImagePath(): String {

        return "https://image.tmdb.org/t/p/w500/"
    }
}