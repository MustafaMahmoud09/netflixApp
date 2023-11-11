package com.lomu.pagination.Movie

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.lomu.api.endPoint.MovieApi
import com.lomu.mapper.Group.MappingMovieCastFromDtoToModel
import com.lomu.model.MovieCast

class CastMovieDataSource(
    private val movieApi: MovieApi,
    private val movieId: String,
    private val mappingMovieCastFromDtoToModel: MappingMovieCastFromDtoToModel
) : PagingSource<Int, MovieCast>() {

    override fun getRefreshKey(state: PagingState<Int, MovieCast>): Int? {

        return state.anchorPosition
    }


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieCast> {

        return try {
            val response = mappingMovieCastFromDtoToModel.convertList(
                movieApi.executeGetMovieCast(
                    id = movieId
                ).cast
            )
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = null
            )
        } catch (ex: Exception) {
            LoadResult.Error(
                throwable = ex
            )
        }

    }
}