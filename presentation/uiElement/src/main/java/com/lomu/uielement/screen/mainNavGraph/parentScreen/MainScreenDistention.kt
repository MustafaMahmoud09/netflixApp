package com.lomu.uielement.screen.mainNavGraph.parentScreen


import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.lomu.uielement.Transition.OTransition
import com.lomu.uielement.navGraph.MOVIE_NAV_GRAPH_ROUTE
import com.lomu.uielement.navGraph.START_GRAPH_ROUTE
import com.lomu.uielement.screen.movieNavGraph.movieDistention.MOVIE_DISTENTION_ROUTE

private const val ROUTE = "mainScreenDistention"
const val MAIN_DISTENTION_ROUTE = ROUTE

fun NavHostController.navigateToMainNavGraph() {
    this.navigate(ROUTE) {
        popUpTo(START_GRAPH_ROUTE) {
            inclusive = true
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.mainScreenDistention(
    navHostController: NavHostController,
) {

    composable(
        route = ROUTE,
        enterTransition = { enterTransition() },
        exitTransition = { existTransition() },
        popEnterTransition = { popEnterTransition() },
    ) {
        MainScreen(
            navRootController = navHostController
        )
    }

}


@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.enterTransition(): EnterTransition? {

    return when (initialState.destination.route) {

        START_GRAPH_ROUTE -> {
            slideIntoContainer(
                AnimatedContentScope.SlideDirection.Right,
                animationSpec = tween(OTransition.TRANSITION_TIME)
            )
        }

        else -> null

    }

}


@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.popEnterTransition(): EnterTransition? {

    return slideIntoContainer(
        AnimatedContentScope.SlideDirection.Right,
        animationSpec = tween(300)
    )

}

@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.existTransition(): ExitTransition? {

    return when (initialState.destination.route) {

        MOVIE_NAV_GRAPH_ROUTE -> {
            fadeOut(
                animationSpec = tween(OTransition.TRANSITION_TIME)
            )
        }

        else -> null
    }

}