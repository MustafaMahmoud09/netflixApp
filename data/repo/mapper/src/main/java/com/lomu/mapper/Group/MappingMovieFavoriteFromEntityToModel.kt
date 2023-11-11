package com.lomu.mapper.Group

import com.lomu.entity.MovieFavoriteEntity
import com.lomu.mapper.Base.MappingList
import com.lomu.model.MovieFavorite

class MappingMovieFavoriteFromEntityToModel : MappingList<MovieFavoriteEntity, MovieFavorite>() {

    override fun convertList(data: List<MovieFavoriteEntity?>?): List<MovieFavorite> {

        return data!!.map {
            convertObject(it!!)
        }
    }

    override fun convertObject(data: MovieFavoriteEntity): MovieFavorite {

        return MovieFavorite(
            id = data.id,
            path = data.path,
            title = data.title,
            vote = data.vote
        )
    }

}