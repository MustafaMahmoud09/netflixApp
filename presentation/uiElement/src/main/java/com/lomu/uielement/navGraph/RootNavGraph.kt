package com.lomu.uielement.navGraph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.lomu.uielement.screen.BaseScreen
import com.lomu.uielement.screen.mainNavGraph.parentScreen.mainScreenDistention
import com.lomu.uielement.theme.netflixTheme


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RootNavGraph(
    navHostController: NavHostController,
) {
    val theme = netflixTheme()
    BaseScreen(
        theme = theme,
        bottom = theme
            .bottomBackground
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = theme
                        .background
                )
        ) {
            AnimatedNavHost(
                navController = navHostController,
                startDestination = START_GRAPH_ROUTE
            ) {
                startNavGraph(
                    navHostController = navHostController
                )
                mainScreenDistention(
                    navHostController = navHostController
                )
                movieNavGraph()
            }
        }
    }
}