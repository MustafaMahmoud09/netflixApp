package com.lomu.state

import androidx.paging.PagingData
import com.lomu.model.MovieSearch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

data class SearchUiState(
    val key: MutableStateFlow<String> = MutableStateFlow(""),
    val dataSearch: Flow<PagingData<MovieSearch>>? = null,
    val internetState : Int = 2
)