package com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.favoriteScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.lomu.uielement.R

private const val ROUTE = "favoriteDistention"
val FAVORITE_SCREEN_ROUTE =
    arrayListOf(ROUTE, R.drawable.ic_baseline_favorite_border_24, R.string.favorite)

fun NavGraphBuilder.favoriteDistention(
    navRootController: NavHostController,
) {
    composable(
        route = ROUTE
    ) {
        FavoriteScreen(
            navRootController = navRootController
        )
    }
}