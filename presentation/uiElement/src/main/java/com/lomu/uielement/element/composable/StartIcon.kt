package com.lomu.uielement.element.composable

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.lomu.uielement.R
import com.lomu.uielement.theme.mode.CustomColors

@Composable
fun StartIcon(
    theme : CustomColors,
    modifier: Modifier = Modifier,
    color : Color = theme.gold,
    painter: Painter = painterResource(
        id = R.drawable.ic_baseline_star_outline_24
    )
){
    Icon(
        modifier = modifier,
        painter = painter,
        contentDescription = "icon",
        tint = color,
    )
}