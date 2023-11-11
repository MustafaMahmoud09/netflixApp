package com.lomu.uielement.screen.movieNavGraph.movieDistention

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable

private const val ROUTE = "movieDistention"
const val MOVIE_DISTENTION_ROUTE = ROUTE

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.movieDistention() {

    composable(
        route = ROUTE,
    ) {
        MovieScreen()
    }

}