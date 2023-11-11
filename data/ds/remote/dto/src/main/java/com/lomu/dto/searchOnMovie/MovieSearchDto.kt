package com.lomu.dto.searchOnMovie


import com.google.gson.annotations.SerializedName
import com.lomu.dto.ResultDto

data class MovieSearchDto(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<ResultDto?>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)