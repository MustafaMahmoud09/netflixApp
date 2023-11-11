package com.lomu.uielement.element.lazyItem


import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lomu.uielement.R
import com.lomu.uielement.element.composable.CustomEditField
import com.lomu.uielement.element.modifier.shadow
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors

@Composable
fun CardItemSearch(
    text: String,
    onChange: (String) -> Unit,
    dimens: CustomDimens,
    theme: CustomColors,
) {
    val infiniteTransition = rememberInfiniteTransition()

    val colorBorder by infiniteTransition.animateColor(
        initialValue = theme.gold,
        targetValue = theme.gold,
        animationSpec = infiniteRepeatable(
            animation = tween(3000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .background(
                theme.background
            )
            .padding(horizontal = dimens.dimen_0_5.dp)
            .padding(top = dimens.dimen_1.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.dimen_6.dp)
                .shadow(
                    theme = theme,
                    dimens = dimens
                )
                .clip(RoundedCornerShape(45))
                .background(
                    color = theme.bottomBackground
                ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = dimens.dimen_1.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_baseline_search_24
                        ),
                        contentDescription = "search icon",
                        tint = theme.infCardColor
                    )
                    CustomEditField(
                        text = text,
                        onChange = onChange,
                        textColor = theme.inflect,
                        hintColor = Color.LightGray,
                        dimens = dimens
                    )
                }
            }
        }
    }
}