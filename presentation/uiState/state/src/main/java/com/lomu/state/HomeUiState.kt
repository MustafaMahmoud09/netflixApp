package com.lomu.state

import androidx.paging.PagingData
import com.lomu.model.MovieHome
import kotlinx.coroutines.flow.Flow

data class HomeUiState(
    val headerData: Flow<PagingData<MovieHome>>? = null,
    val subHeaderData: Flow<PagingData<MovieHome>>? = null,
    val popularData: Flow<PagingData<MovieHome>>? = null,
    val topRateData: Flow<PagingData<MovieHome>>? = null,
    val lastWeekData: Flow<PagingData<MovieHome>>? = null
)