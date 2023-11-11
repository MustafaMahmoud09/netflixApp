package com.lomu.mapper.Group

import com.lomu.dto.ResultDto
import com.lomu.mapper.Base.MappingList
import com.lomu.model.MovieSearch

class MappingMovieSearchFromDtoToModel(
   private val pathImage: String
) : MappingList<ResultDto, MovieSearch>() {

    override fun convertList(data: List<ResultDto?>?): List<MovieSearch> {

        return data!!.map {
            convertObject(it!!)
        }

    }

    override fun convertObject(data: ResultDto): MovieSearch {

        return MovieSearch(
            id = data.id.toString(),
            title = data.originalTitle!!.trim(),
            vote = data.voteAverage.toString(),
            date = data.releaseDate.toString(),
            image = pathImage+ if (data.posterPath.toString() != "null") data.posterPath else data.backdropPath,
            language = if(data.originalLanguage.toString() == "null") "" else data.originalLanguage.toString()
        )
    }


}