package com.lomu.uielement.screen.mainNavGraph.parentScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lomu.uielement.element.composable.BottomNavigation
import com.lomu.uielement.navGraph.MainNavGraph
import com.lomu.uielement.screen.BaseScreen
import com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.favoriteScreen.FAVORITE_SCREEN_ROUTE
import com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.homeScreen.HOME_SCREEN_ROUTE
import com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.searchScreen.SEARCH_SCREEN_ROUTE
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.theme.netflixDimens
import com.lomu.uielement.theme.netflixTheme
import java.util.ArrayList

@Composable
fun MainScreen(
    navRootController: NavHostController,
) {
    val items = listOf(
        HOME_SCREEN_ROUTE,
        SEARCH_SCREEN_ROUTE,
        FAVORITE_SCREEN_ROUTE,
    )
    MainContent(
        theme = netflixTheme(),
        dimen = netflixDimens(),
        navController = rememberNavController(),
        items = items,
        navRootController = navRootController
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainContent(
    theme: CustomColors,
    dimen: CustomDimens,
    navController: NavHostController,
    items: List<ArrayList<out Any>>,
    navRootController: NavHostController,
) {
    BaseScreen(
        theme = theme,
        bottom = theme.bottomBackground
    ) {
        Scaffold(
            modifier = Modifier
                .safeDrawingPadding(),
            bottomBar = {
                BottomNavigation(
                    backgroundColor = theme
                        .bottomBackground,
                ) {
                    BottomNavigation(
                        navController = navController,
                        items = items,
                        theme = theme,
                        dimen = dimen
                    )
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        bottom = dimen.dimen_7.dp
                    )
                    .background(
                        color = theme.background
                    )
            ) {
                MainNavGraph(
                    navHostController = navController,
                    navRootController = navRootController
                )
            }
        }
    }
}