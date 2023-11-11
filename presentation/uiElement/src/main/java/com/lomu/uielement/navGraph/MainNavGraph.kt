package com.lomu.uielement.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.favoriteScreen.favoriteDistention
import com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.homeScreen.HOME_SCREEN_ROUTE
import com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.homeScreen.homeDistention
import com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.searchScreen.searchDistention


@Composable
fun MainNavGraph(
    navHostController: NavHostController,
    navRootController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = HOME_SCREEN_ROUTE[0].toString()
    ) {
        homeDistention(
            navRootController = navRootController
        )
        searchDistention(
            navRootController = navRootController
        )
        favoriteDistention(
            navRootController = navRootController
        )
    }
}