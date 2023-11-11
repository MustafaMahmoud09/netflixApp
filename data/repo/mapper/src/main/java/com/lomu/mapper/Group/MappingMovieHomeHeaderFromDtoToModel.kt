package com.lomu.mapper.Group

import com.lomu.dto.ResultDto
import com.lomu.mapper.Base.MappingList
import com.lomu.model.MovieHome

class MappingMovieHomeHeaderFromDtoToModel(
   private val imagePath : String
) : MappingList<ResultDto, MovieHome>() {

    override fun convertList(data: List<ResultDto?>?): List<MovieHome> {

        return data!!.map {
            convertObject(it!!)
        }
    }

    override fun convertObject(data: ResultDto): MovieHome {

        return MovieHome(
            id = data.id.toString(),
            image = imagePath+data.backdropPath,
            rate = data.voteAverage.toString()
        )
    }

}