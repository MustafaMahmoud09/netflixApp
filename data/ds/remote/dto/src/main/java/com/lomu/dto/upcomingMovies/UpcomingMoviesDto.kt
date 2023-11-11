package com.lomu.dto.upcomingMovies


import com.google.gson.annotations.SerializedName
import com.lomu.dto.ResultDto

data class UpcomingMoviesDto(
    @SerializedName("dates")
    val dates: Dates? = null,
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<ResultDto?>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)