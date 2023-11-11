package com.lomu.pagination.Search

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.lomu.api.endPoint.MovieApi
import com.lomu.mapper.Group.MappingMovieSearchFromDtoToModel
import com.lomu.model.MovieSearch


class MovieSearchDataSource(
    private val key: String,
    private val language: String,
    private val movieApi: MovieApi,
    private val mappingMovieSearchFromDtoToModel: MappingMovieSearchFromDtoToModel,
) : PagingSource<Int, MovieSearch>() {

    override fun getRefreshKey(state: PagingState<Int, MovieSearch>): Int? {

        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieSearch> {

        return try {
            val numberOfPage = params.key ?: 1
            val response = mappingMovieSearchFromDtoToModel.convertList(
                movieApi.executeSearchOnMovie(
                    query = key,
                    language = language,
                    page = numberOfPage
                ).results
            )
            LoadResult.Page(
                data = response,
                prevKey = if (numberOfPage == 1) null else numberOfPage.minus(1),
                nextKey = if (response.isEmpty()) null else numberOfPage.plus(1)
            )
        } catch (ex: Exception) {

            LoadResult.Error(
                throwable = ex
            )
        }
    }
}