package com.lomu.uielement.element.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors

@Composable
fun CustomProgress(
    theme: CustomColors,
    dimen: CustomDimens,
    size: Int = dimen.dimen_6,
) {
    CircularProgressIndicator(
        color = theme.redIcon,
        strokeWidth = dimen.dimen_0_25.dp,
        modifier = Modifier
            .size(size.dp)
    )
}