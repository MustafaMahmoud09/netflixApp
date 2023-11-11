package com.lomu.uielement.navGraph

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.*
import com.google.accompanist.navigation.animation.navigation
import com.lomu.uielement.Transition.OTransition
import com.lomu.uielement.screen.mainNavGraph.parentScreen.MAIN_DISTENTION_ROUTE
import com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.homeScreen.HOME_SCREEN_ROUTE
import com.lomu.uielement.screen.movieNavGraph.movieDistention.MOVIE_DISTENTION_ROUTE
import com.lomu.uielement.screen.movieNavGraph.movieDistention.movieDistention
import com.lomu.viewmodel.viewModel.MovieViewModel

private const val ROUTE = "movieNavGraph"
const val MOVIE_NAV_GRAPH_ROUTE = ROUTE

fun NavHostController.navigateToMovieNavGraph(
    movieId: String
) {
    MovieArg.MOVIE_ID = movieId
    this.navigate("$ROUTE/$movieId")
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.movieNavGraph() {

    navigation(
        route = "$ROUTE/{${MovieArg.movieId}}",
        arguments = listOf(navArgument(MovieArg.movieId) { type = NavType.StringType }),
        startDestination = MOVIE_DISTENTION_ROUTE,
        enterTransition = { enterTransition() },
        popExitTransition = { popExistTransition() }
    ) {
        movieDistention()
    }

}


class MovieArg(
    savedStateHandle: SavedStateHandle,
) {
    val id: String = checkNotNull(savedStateHandle[movieId])

    companion object {
        var MOVIE_ID: String = ""
        const val movieId = "movieId"
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.enterTransition(): EnterTransition? {

    return when (initialState.destination.route) {

        MAIN_DISTENTION_ROUTE -> {
            slideIntoContainer(
                AnimatedContentScope.SlideDirection.Left,
                animationSpec = tween(OTransition.TRANSITION_TIME)
            )
        }

        else -> null

    }

}

@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.popExistTransition(): ExitTransition? {

    return fadeOut(
        animationSpec = tween(OTransition.TRANSITION_TIME)
    )

}