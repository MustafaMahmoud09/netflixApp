package com.lomu.uielement.element.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lomu.uielement.theme.dimen.CustomDimens

@Composable
fun SpacerVertical4(
    dimens: CustomDimens
) {
    Spacer(
        modifier = Modifier
            .height(dimens.dimen_0_5.dp)
    )
}