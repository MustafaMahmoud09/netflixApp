package com.lomu.state

import androidx.paging.PagingData
import com.lomu.model.Movie
import com.lomu.model.MovieCast
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

data class MovieUiState(
    val movieId: MutableStateFlow<String> = MutableStateFlow(""),
    val movieDetail: Flow<PagingData<Movie>>? = null,
    val movieCast: Flow<PagingData<MovieCast>>? = null,
    val saved : Boolean = false
)