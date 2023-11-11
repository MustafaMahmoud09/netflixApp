package com.lomu.mapper.One

import com.lomu.entity.MovieFavoriteEntity
import com.lomu.mapper.Base.MappingObj
import com.lomu.model.MovieFavorite

class MappingMovieFavoriteFromModelToEntity : MappingObj<MovieFavorite, MovieFavoriteEntity>() {

    override fun convertObj(data: MovieFavorite): List<MovieFavoriteEntity> {
        return listOf(
            MovieFavoriteEntity(
                id = data.id,
                title = data.title,
                path = data.path,
                vote = data.vote
            )
        )
    }
}