package com.lomu.uielement.element.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lomu.uielement.element.lazyItem.TitleCategory
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors

@Composable
fun CardMovieInfoSecondary(
    theme : CustomColors,
    dimens : CustomDimens,
    text : String
){
    Box(
        modifier = Modifier
            .wrapContentSize()
            .clip(
                RoundedCornerShape(
                    percent = 45
                )
            )
            .background(
                color = theme.infMovie
            )
            .padding(
                vertical = dimens.dimen_0_5.dp,
                horizontal = dimens.dimen_2_5.dp
            )
    ) {
        TitleCategory(
            dimens = dimens,
            theme = theme,
            text = text,
            size = dimens.dimen_1_75.toInt(),
            color = Color.Black
        )
    }
}