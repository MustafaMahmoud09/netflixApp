package com.lomu.repository.repository

import com.lomu.irepository.IFavoriteRepository
import com.lomu.mapper.Group.MappingMovieFavoriteFromEntityToModel
import com.lomu.mapper.One.MappingMovieFavoriteFromModelToEntity
import com.lomu.model.MovieFavorite
import com.lomu.repository.base.BaseRepository
import com.lomu.room.NetflixDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FavoriteRepository(
    private val roomDatabase: NetflixDatabase,
    private val mappingMovieFavoriteFromEntityToModel: MappingMovieFavoriteFromEntityToModel,
    private val mappingMovieFavoriteFromModelToEntity: MappingMovieFavoriteFromModelToEntity
) : BaseRepository(), IFavoriteRepository {

    override fun getMovieById(
        id: String
    ): List<MovieFavorite> {

        return mappingMovieFavoriteFromEntityToModel.convertList(
            roomDatabase.netflixDao().getMovieById(id)
        )
    }

    override suspend fun insertFavoriteMovie(
        movieFavorite: MovieFavorite
    ) {

        roomDatabase.netflixDao().insertFavoriteMovie(
            movie = mappingMovieFavoriteFromModelToEntity.convertObj(
                data = movieFavorite
            )[0]
        )
    }

    override suspend fun removeFavoriteMovie(
        id: String
    ) {

        roomDatabase.netflixDao().deleteMovie(
            id = id
        )
    }

    override fun getFavoriteMovies(): Flow<List<MovieFavorite>> {

        return flow {
            roomDatabase.netflixDao().selectAllMovieFavorite().collect {
                val list: List<MovieFavorite> = mappingMovieFavoriteFromEntityToModel.convertList(
                    data = it
                )
                emit(list)
            }
        }
    }
}
