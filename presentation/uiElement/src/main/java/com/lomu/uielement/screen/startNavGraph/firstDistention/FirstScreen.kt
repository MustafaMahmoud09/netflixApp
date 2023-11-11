package com.lomu.uielement.screen.startNavGraph.firstDistention

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import com.lomu.uielement.screen.BaseScreen
import com.lomu.uielement.screen.mainNavGraph.parentScreen.navigateToMainNavGraph
import com.lomu.uielement.R
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.element.composable.BasicLogo
import com.lomu.uielement.element.composable.GuideLineEnd33P
import com.lomu.uielement.element.composable.GuideLineStart33P
import com.lomu.uielement.element.composable.Title
import com.lomu.uielement.theme.netflixDimens
import com.lomu.uielement.theme.netflixTheme
import kotlinx.coroutines.delay

@Composable
fun FirstScreen(
    navHostController: NavHostController,
) {
    val theme = netflixTheme()
    val dimens = netflixDimens()
    FirstContent(
        theme = theme,
        dimen = dimens,
        navController = navHostController
    )
}

@Composable
private fun FirstContent(
    theme: CustomColors,
    dimen: CustomDimens,
    navController: NavHostController,
) {
    BaseScreen(
        theme = theme
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = theme
                        .background
                )
        ) {
            val (logo, title) = createRefs()
            val guideStart30P = GuideLineStart33P()
            val guideEnd30P = GuideLineEnd33P()
            BasicLogo(
                modifier = Modifier
                    .constrainAs(logo) {
                        start.linkTo(guideStart30P)
                        end.linkTo(guideEnd30P)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                    }
            )
            Title(
                text = stringResource(
                    R.string.netflix
                ),
                theme = theme,
                dimen = dimen,
                modifier = Modifier
                    .constrainAs(title) {
                        start.linkTo(logo.start)
                        end.linkTo(logo.end)
                        top.linkTo(logo.bottom)
                    }
            )
        }
    }

    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigateToMainNavGraph()
    }
}