package com.lomu.mapper.Group

import com.lomu.dto.movieCast.Cast
import com.lomu.mapper.Base.MappingList
import com.lomu.model.MovieCast

class MappingMovieCastFromDtoToModel(
    private val pathImage: String
) : MappingList<Cast, MovieCast>() {

    override fun convertList(data: List<Cast?>?): List<MovieCast> {

        return data!!.map {
            convertObject(it!!)
        }
    }

    override fun convertObject(data: Cast): MovieCast {

        return MovieCast(
            id = data.id.toString(),
            image = pathImage + data.profilePath,
            title = data.name!!,
            type = data.knownForDepartment!!
        )
    }
}