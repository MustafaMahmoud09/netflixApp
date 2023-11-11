package com.lomu.uielement.element.composable


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lomu.uielement.R
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors

@Composable
fun RatingBar(
    dimens: CustomDimens,
    theme: CustomColors,
    rating: Float,
    modifier: Modifier = Modifier,
    size: Float = dimens.dimen_3_5.toFloat(),
    colorEmpty: Color = theme.inflect,
    colorNotEmpty: Color = theme.redIcon,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 0 until rating.toInt()) {
            CustomStar(
                color = colorNotEmpty,
                size = size
            )
        }

        for (i in 0 until 5 - rating.toInt()) {
            if (
                i == 0 &&
                (5 - rating) - (5 - rating).toInt() <= 0.5
                && (5 - rating) - (5 - rating).toInt() > 0F
            ) {
                CustomStar(
                    paint = R.drawable.ic_baseline_star_half_24,
                    color = colorNotEmpty,
                    size = size
                )
            } else {
                CustomStar(
                    size = size,
                    color = colorEmpty
                )
            }
        }
    }
}


@Composable
fun CustomStar(
    modifier: Modifier = Modifier,
    paint: Int = R.drawable.ic_baseline_star_24,
    color: Color,
    size: Float,
) {
    Icon(
        painter = painterResource(
            id = paint
        ),
        contentDescription = "star icon",
        tint = color,
        modifier = modifier.size(size.dp)
    )
}