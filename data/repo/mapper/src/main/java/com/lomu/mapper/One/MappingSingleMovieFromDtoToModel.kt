package com.lomu.mapper.One

import com.lomu.dto.singleMovie.Genre
import com.lomu.dto.singleMovie.SingleMovieDto
import com.lomu.mapper.Base.MappingObj
import com.lomu.model.Movie
import java.security.spec.ECField
import java.util.*

class MappingSingleMovieFromDtoToModel(
    private val imagePath: String,
) : MappingObj<SingleMovieDto, Movie>() {

    override fun convertObj(data: SingleMovieDto): List<Movie> {

        return listOf(
            Movie(
                id = data.id!!,
                title = data.originalTitle!!,
                hours = getHoursMovie(data.runtime.toString()),
                minute = getMinuteMovie(data.runtime.toString()),
                description = data.overview!!,
                vote = data.voteAverage!!,
                language = data.originalLanguage!!,
                image = imagePath + try {
                    data.belongsToCollection?.backdropPath!!
                } catch (ex: Exception) {
                    data.backdropPath
                } catch (ex: Exception) {
                    data.posterPath
                } catch (ex: Exception) {
                    ""
                },
                date = data.releaseDate.toString().substring(0, 4),
                type = getMovieTypes(data.genres)
            )
        )
    }

    private fun getMovieTypes(data: List<Genre?>?): String {
        var output = ""
        return try {
            for (item in 0 until data!!.size) {
                if (item == 0) {
                    output += data[item]?.name!!
                    continue
                }
                output += "*${data[item]?.name!!}"
            }
            output
        } catch (ex: Exception) {
            ""
        }
    }

    private fun getHoursMovie(time: String): String {
        return try {
            (time.toInt() / 60).toString()
        } catch (ex: Exception) {
            "2"
        }
    }

    private fun getMinuteMovie(time: String): String {
        return try {
            (time.toInt() - getHoursMovie(time).toInt() * 60).toString()
        } catch (ex: Exception) {
            return "0"
        }
    }
}