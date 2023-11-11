package com.lomu.uielement.stateScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.lomu.uielement.element.composable.CustomProgress
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.theme.netflixDimens
import com.lomu.uielement.theme.netflixTheme

@Composable
fun LoadingScreen(
    theme : CustomColors = netflixTheme(),
    dimens : CustomDimens = netflixDimens()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(theme.background),
        contentAlignment = Alignment.Center
    ) {
        CustomProgress(
            theme = theme,
            dimen = dimens
        )
    }
}