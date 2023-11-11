package com.lomu.uielement.element.modifier

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors

@Stable
fun Modifier.shadow(
    theme : CustomColors,
    dimens: CustomDimens,
    shape: Shape = RoundedCornerShape(45),
    elevation:Float = dimens.dimen_1.toFloat()
): Modifier {
    return then(Modifier.shadow(
        elevation = elevation.dp,
        shape = shape,
        clip = true,
        ambientColor = theme.gold,
        spotColor = theme.red
    ))
}