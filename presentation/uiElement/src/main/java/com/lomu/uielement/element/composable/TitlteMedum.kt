package com.lomu.uielement.element.composable

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.theme.openSansRegular

@Composable
fun TitleMedium(
    text:String,
    dimens: CustomDimens,
    theme: CustomColors,
    size: Float = dimens.dimen_1_75,
    color: Color = theme.white,
    font: FontFamily = openSansRegular,
    modifier: Modifier = Modifier,
    numOfLine : Boolean = true
) {
    if (numOfLine) {
        Text(
            text = text,
            fontSize = size.sp,
            fontFamily = font,
            color = color,
            maxLines = 1,
            modifier = modifier,
            textAlign = TextAlign.Center
        )
    }else{
        Text(
            text = text,
            fontSize = size.sp,
            fontFamily = font,
            color = color,
            modifier = modifier,
            textAlign = TextAlign.Center
        )
    }
}