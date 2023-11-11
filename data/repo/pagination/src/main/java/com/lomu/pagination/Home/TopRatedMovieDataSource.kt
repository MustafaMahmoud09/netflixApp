package com.lomu.pagination.Home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.lomu.api.endPoint.MovieApi
import com.lomu.mapper.Group.MappingMovieHomeFromDtoToModel
import com.lomu.model.MovieHome

class TopRatedMovieDataSource(
    private val movieApi: MovieApi,
    private val mappingMovieHomeFromDtoToModel: MappingMovieHomeFromDtoToModel,
    private val language: String
) : PagingSource<Int, MovieHome>() {

    override fun getRefreshKey(state: PagingState<Int, MovieHome>): Int? {

        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieHome> {
        return try {
            val page = params.key ?: 1
            val response = mappingMovieHomeFromDtoToModel.convertList(
                movieApi.executeGetTopRatedMovies(
                    page = page,
                    language = language
                ).results
            )
            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.isEmpty()) null else page.plus(1)
            )
        } catch (ex: Exception) {
            LoadResult.Error(
                throwable = ex
            )
        }
    }
}