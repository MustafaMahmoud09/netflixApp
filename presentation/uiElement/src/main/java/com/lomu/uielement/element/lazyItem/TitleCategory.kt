package com.lomu.uielement.element.lazyItem

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.theme.robotoMedium

@Composable
fun TitleCategory(
    dimens: CustomDimens,
    theme: CustomColors,
    text: String,
    size: Int = dimens.dimen_2,
    color: Color = theme.inflect,
    modifier: Modifier = Modifier,
    font: androidx.compose.ui.text.font.FontFamily = robotoMedium
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = size.sp,
        fontFamily = font,
        color = color
    )
}