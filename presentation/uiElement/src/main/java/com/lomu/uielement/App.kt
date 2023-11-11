package com.lomu.uielement

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lomu.uielement.navGraph.RootNavGraph

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun App() {

    val navController = rememberAnimatedNavController()
     RootNavGraph(
         navHostController = navController
     )
}