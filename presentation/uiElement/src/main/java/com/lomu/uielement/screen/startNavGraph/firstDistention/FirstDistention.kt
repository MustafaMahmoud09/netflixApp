package com.lomu.uielement.screen.startNavGraph.firstDistention


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable

private const val ROUTE = "FirstDistention"
const val FIRST_DISTENTION_ROUTE = ROUTE

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.firstDistention(
    navHostController: NavHostController,
) {
    composable(
        route = ROUTE
    ) {
        FirstScreen(navHostController)
    }
}

