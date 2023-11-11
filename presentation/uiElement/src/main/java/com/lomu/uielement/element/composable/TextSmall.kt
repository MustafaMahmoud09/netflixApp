package com.lomu.uielement.element.composable

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.theme.openSansCondensedRegular

@Composable
fun TextSmall(
    text : String,
    theme : CustomColors,
    dimens: CustomDimens,
    color : Color = theme.gold,
    size : Float = dimens.dimen_1_75
) {
    Text(
        text = text,
        fontFamily = openSansCondensedRegular,
        color = color,
        fontSize = size.sp
    )
}