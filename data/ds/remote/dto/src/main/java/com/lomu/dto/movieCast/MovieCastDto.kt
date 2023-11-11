package com.lomu.dto.movieCast


import com.google.gson.annotations.SerializedName

data class MovieCastDto(
    @SerializedName("cast")
    val cast: List<Cast?>? = null,
    @SerializedName("crew")
    val crew: List<Crew?>? = null,
    @SerializedName("id")
    val id: Int? = null
)