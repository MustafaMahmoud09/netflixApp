package com.lomu.uielement.element.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.lomu.uielement.R
import com.lomu.uielement.theme.dimen.CustomDimens

@Composable
fun CustomEditField(
    text: String,
    onChange: (String) -> Unit,
    textColor: Color,
    hintColor: Color,
    dimens: CustomDimens,
) {
    BasicTextField(
        value = text,
        textStyle = LocalTextStyle.current.copy(
            color = textColor
        ),
        onValueChange = onChange,
        modifier = Modifier
            .fillMaxWidth(),
        singleLine = true,

        decorationBox = { innerTextField ->
            AnimatedVisibility(
                text.isEmpty()
            ) {
                Text(
                    text = stringResource(
                        R.string.search_hint
                    ),
                    color = hintColor,
                    fontSize = dimens.dimen_1_75.sp
                )
            }
            // <-- Add this
            innerTextField()
        },
    )
}