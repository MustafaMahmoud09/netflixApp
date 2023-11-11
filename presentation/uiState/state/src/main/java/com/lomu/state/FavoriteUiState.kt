package com.lomu.state

import com.lomu.model.MovieFavorite

data class FavoriteUiState(
    val bottomSheet: Int = 1,
    val data: List<MovieFavorite> = emptyList(),
    val itemDeleted : String = ""
)
