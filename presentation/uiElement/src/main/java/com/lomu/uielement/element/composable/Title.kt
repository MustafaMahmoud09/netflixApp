package com.lomu.uielement.element.composable

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.theme.openSansCondensedSemiBold

@Composable
fun Title(
    text: String,
    theme: CustomColors,
    dimen: CustomDimens,
    size: Int = dimen.dimen_5_5,
    color: Color = theme.red,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontFamily = openSansCondensedSemiBold,
        fontSize = size.sp,
        letterSpacing = TextUnit(2F, TextUnitType.Sp)
    )
}