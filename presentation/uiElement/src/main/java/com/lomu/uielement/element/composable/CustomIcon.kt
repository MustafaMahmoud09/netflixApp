package com.lomu.uielement.element.composable

import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lomu.uielement.R
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors

@Composable
fun CustomIcon(
    theme : CustomColors,
    dimens : CustomDimens,
    width : Float = dimens.dimen_3.toFloat(),
    modifier: Modifier = Modifier,
    icon : Int = R.drawable.option,
    color: Color = theme.white
){
    Icon(
        painter = painterResource(
            id = icon
        ),
        contentDescription = "menu",
        tint = color,
        modifier = modifier
            .width(width.dp)
    )
}