package com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.searchScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.lomu.uielement.R

private const val ROUTE = "searchDistention"
val SEARCH_SCREEN_ROUTE = arrayListOf(ROUTE, R.drawable.ic_baseline_search_24, R.string.search)

fun NavGraphBuilder.searchDistention(
    navRootController: NavHostController,
) {
    composable(
        route = ROUTE
    ) {
        SearchScreen(
            navRootController = navRootController
        )
    }
}