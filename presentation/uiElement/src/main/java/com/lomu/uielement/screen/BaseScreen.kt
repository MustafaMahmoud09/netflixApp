package com.lomu.uielement.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.lomu.uielement.theme.mode.CustomColors

@Composable
fun BaseScreen(
    theme: CustomColors,
    top: Color = theme.systemUi,
    bottom: Color = theme.systemUi,
    topVisible: Boolean = true,
    bottomVisible: Boolean = true,
    content: @Composable () -> Unit,
) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    BaseContent(
        systemUiController = systemUiController,
        useDarkIcons = useDarkIcons,
        top = top,
        bottom = bottom,
        content = content,
        topVisible = topVisible,
        bottomVisible = bottomVisible
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun BaseContent(
    systemUiController: SystemUiController,
    useDarkIcons: Boolean,
    top: Color,
    bottom: Color,
    topVisible : Boolean ,
    bottomVisible : Boolean ,
    content: @Composable () -> Unit,
) {

    content()

    DisposableEffect(systemUiController, useDarkIcons) {

        systemUiController.isStatusBarVisible = topVisible
        systemUiController.isNavigationBarVisible = bottomVisible

        systemUiController.setStatusBarColor(
            color = top,
            darkIcons = useDarkIcons
        )
        systemUiController.setNavigationBarColor(
            color = bottom,
            darkIcons = useDarkIcons
        )
        onDispose { }
    }
}