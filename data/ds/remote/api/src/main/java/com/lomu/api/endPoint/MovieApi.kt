package com.lomu.api.endPoint

import com.lomu.dto.lastWeekMovies.LastWeekMovies
import com.lomu.dto.movieCast.MovieCastDto
import com.lomu.dto.nowPlayingMovies.NowPlayingMovies
import com.lomu.dto.popularMovies.PopularMoviesDto
import com.lomu.dto.searchOnMovie.MovieSearchDto
import com.lomu.dto.singleMovie.SingleMovieDto
import com.lomu.dto.topRatedMovies.TopRatedMoviesDto
import com.lomu.dto.upcomingMovies.UpcomingMoviesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieApi {

    @GET("search/movie")
    suspend fun executeSearchOnMovie(
        @Query("query") query: String,
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MovieSearchDto

    @GET("movie/{id}")
    suspend fun executeGetSingleMovie(
        @Path("id") id: String,
    ): SingleMovieDto

    @GET("movie/{id}/credits")
    suspend fun executeGetMovieCast(
        @Path("id") id: String,
    ): MovieCastDto

    @GET("movie/popular")
    suspend fun executeGetPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): PopularMoviesDto

    @GET("movie/upcoming")
    suspend fun executeGetUpcomingMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): UpcomingMoviesDto

    @GET("movie/now_playing")
    suspend fun executeGetNowPlayingMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): NowPlayingMovies

    @GET("trending/movie/week")
    suspend fun executeGetLastWeekMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): LastWeekMovies

    @GET("movie/top_rated")
    suspend fun executeGetTopRatedMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): TopRatedMoviesDto

}
