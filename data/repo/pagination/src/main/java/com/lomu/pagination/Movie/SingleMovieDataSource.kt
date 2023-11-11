package com.lomu.pagination.Movie

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.lomu.api.endPoint.MovieApi
import com.lomu.mapper.One.MappingSingleMovieFromDtoToModel
import com.lomu.model.Movie

class SingleMovieDataSource(
    private val movieApi: MovieApi,
    private val movieId: String,
    private val mappingSingleMovieFromDtoToModel: MappingSingleMovieFromDtoToModel,
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {

        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {

        return try {
            val response = mappingSingleMovieFromDtoToModel.convertObj(
                movieApi.executeGetSingleMovie(
                    id = movieId
                )
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