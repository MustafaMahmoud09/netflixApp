package com.lomu.repository.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lomu.api.endPoint.MovieApi
import com.lomu.irepository.IMovieRepository
import com.lomu.mapper.Group.MappingMovieCastFromDtoToModel
import com.lomu.mapper.Group.MappingMovieHomeFromDtoToModel
import com.lomu.mapper.Group.MappingMovieHomeHeaderFromDtoToModel
import com.lomu.mapper.Group.MappingMovieSearchFromDtoToModel
import com.lomu.mapper.One.MappingSingleMovieFromDtoToModel
import com.lomu.model.Movie
import com.lomu.model.MovieCast
import com.lomu.model.MovieHome
import com.lomu.model.MovieSearch
import com.lomu.pagination.Home.*
import com.lomu.pagination.Movie.CastMovieDataSource
import com.lomu.pagination.Search.MovieSearchDataSource
import com.lomu.pagination.Movie.SingleMovieDataSource
import com.lomu.repository.base.BaseRepository
import com.lomu.room.NetflixDatabase
import kotlinx.coroutines.flow.Flow

class MovieRepository(
    private val movieApi: MovieApi,
    private val roomDatabase: NetflixDatabase,
    private val mappingMovieSearchFromDtoToModel: MappingMovieSearchFromDtoToModel,
    private val mappingSingleMovieFromDtoToModel: MappingSingleMovieFromDtoToModel,
    private val mappingMovieCastFromDtoToModel: MappingMovieCastFromDtoToModel,
    private val mappingMovieHomeFromDtoToModel: MappingMovieHomeFromDtoToModel,
    private val mappingMovieHomeHeaderFromDtoToModel: MappingMovieHomeHeaderFromDtoToModel
) : BaseRepository(), IMovieRepository {

    override fun onSearch(
        key: String,
        language: String,
    ): Flow<PagingData<MovieSearch>> {

        return Pager(
            config = PagingConfig(pageSize = 10)
        ) {
            MovieSearchDataSource(
                key = key,
                language = language,
                movieApi = movieApi,
                mappingMovieSearchFromDtoToModel = mappingMovieSearchFromDtoToModel
            )
        }.flow
    }


    override fun getMovieDetails(
        id: String,
    ): Flow<PagingData<Movie>> {

        return Pager(
            config = PagingConfig(pageSize = 1)
        ) {
            SingleMovieDataSource(
                movieId = id,
                mappingSingleMovieFromDtoToModel = mappingSingleMovieFromDtoToModel,
                movieApi = movieApi
            )
        }.flow
    }

    override fun getMovieCast(
        id: String
    ): Flow<PagingData<MovieCast>> {

        return Pager(
            config = PagingConfig(pageSize = 1)
        ) {
            CastMovieDataSource(
                movieId = id,
                mappingMovieCastFromDtoToModel = mappingMovieCastFromDtoToModel,
                movieApi = movieApi
            )
        }.flow
    }


    override fun getMoviesTopRated(
        language: String
    ): Flow<PagingData<MovieHome>> {

        return Pager(
            config = PagingConfig(pageSize = 20)
        ) {
            TopRatedMovieDataSource(
                movieApi = movieApi,
                language = language,
                mappingMovieHomeFromDtoToModel = mappingMovieHomeFromDtoToModel
            )
        }.flow
    }

    override fun getMoviesLastWeek(
        language: String
    ): Flow<PagingData<MovieHome>> {

        return Pager(
            config = PagingConfig(pageSize = 20)
        ) {
            LastWeekMovieDataSource(
                movieApi = movieApi,
                language = language,
                mappingMovieHomeFromDtoToModel = mappingMovieHomeFromDtoToModel
            )
        }.flow
    }

    override fun getMoviesUpcoming(
        language: String
    ): Flow<PagingData<MovieHome>> {

        return Pager(
            config = PagingConfig(pageSize = 20)
        ) {
            UpcomingMovieDataSource(
                movieApi = movieApi,
                language = language,
                mappingMovieHomeFromDtoToModel = mappingMovieHomeHeaderFromDtoToModel
            )
        }.flow
    }

    override fun getMoviesNowPlaying(
        language: String
    ): Flow<PagingData<MovieHome>> {

        return Pager(
            config = PagingConfig(pageSize = 20)
        ) {
            NowPlayingMovieDataSource(
                movieApi = movieApi,
                language = language,
                mappingMovieHomeFromDtoToModel = mappingMovieHomeHeaderFromDtoToModel
            )
        }.flow
    }

    override fun getMoviesPopular(
        language: String
    ): Flow<PagingData<MovieHome>> {

        return Pager(
            config = PagingConfig(pageSize = 20)
        ) {
            PopularMovieDataSource(
                movieApi = movieApi,
                language = language,
                mappingMovieHomeFromDtoToModel = mappingMovieHomeFromDtoToModel
            )
        }.flow
    }

}