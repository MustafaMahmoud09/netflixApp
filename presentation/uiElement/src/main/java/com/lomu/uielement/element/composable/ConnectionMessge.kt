package com.lomu.uielement.element.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.lomu.uielement.R
import com.lomu.uielement.element.composable.TextSmall
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors

@Composable
fun ConnectionMessage(
    dimen : CustomDimens,
    theme: CustomColors,
    background : Color,
    title : String,
    textColor : Color = theme.white
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimen.dimen_5.dp)
            .background(color = background)
            .padding(dimen.dimen_0_5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextSmall(
            text = title,
            theme = theme,
            dimens = dimen,
            color = textColor
        )
    }
}