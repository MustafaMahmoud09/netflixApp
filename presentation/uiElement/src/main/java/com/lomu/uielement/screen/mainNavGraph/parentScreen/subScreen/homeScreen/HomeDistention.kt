package com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.homeScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.lomu.uielement.R

private const val ROUTE = "homeDistention"

val HOME_SCREEN_ROUTE = arrayListOf(ROUTE, R.drawable.ic_baseline_home_24,R.string.home)

fun NavGraphBuilder.homeDistention(
    navRootController: NavHostController,
) {
    composable(
        route = ROUTE
    ) {
        HomeScreen(
            navRootController = navRootController
        )
    }
}