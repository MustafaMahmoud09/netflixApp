package com.lomu.uielement.element.composable

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.lomu.uielement.theme.dimen.CustomDimens

@Composable
fun TextItem(
    text: String,
    dimens: CustomDimens,
    size : Int = dimens.dimen_1_5
) {
    Text(
        text = text,
        fontSize = size.sp
    )
}