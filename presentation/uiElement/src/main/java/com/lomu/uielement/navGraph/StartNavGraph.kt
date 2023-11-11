package com.lomu.uielement.navGraph


import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.navigation
import com.lomu.uielement.Transition.OTransition
import com.lomu.uielement.screen.mainNavGraph.parentScreen.MAIN_DISTENTION_ROUTE
import com.lomu.uielement.screen.startNavGraph.firstDistention.FIRST_DISTENTION_ROUTE
import com.lomu.uielement.screen.startNavGraph.firstDistention.firstDistention


private const val ROUTE = "startNavGraph"
const val START_GRAPH_ROUTE = ROUTE

fun NavHostController.clearStartNavGraphFromBackStack() {
    this.clearBackStack(START_GRAPH_ROUTE)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.startNavGraph(
    navHostController: NavHostController,
) {
    navigation(
        route = ROUTE,
        startDestination = FIRST_DISTENTION_ROUTE,
        exitTransition = { existTransition() }
    ) {
        firstDistention(navHostController)
    }
}


@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.existTransition(): ExitTransition? {

    return when (initialState.destination.route) {

        MAIN_DISTENTION_ROUTE -> {
            fadeOut(
                animationSpec = tween(OTransition.TRANSITION_TIME)
            )
        }

        else -> null
    }

}