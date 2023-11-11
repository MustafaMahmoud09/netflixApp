package com.lomu.uielement.element.lazyItem

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lomu.uielement.element.composable.CustomIcon
import com.lomu.uielement.element.composable.TitleMedium
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors

@Composable
fun FavoriteOpItem(
    theme: CustomColors,
    dimens: CustomDimens,
    icon: Int,
    text: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(theme.bottomBackground)
            .clickable { onClick() }
            .padding(
                vertical = dimens.dimen_2.dp,
                horizontal = dimens.dimen_1.dp
            ),
        horizontalArrangement = Arrangement
            .spacedBy(
                dimens.dimen_1_5.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomIcon(
            theme = theme,
            dimens = dimens,
            icon = icon,
            color = theme.redIcon
        )

        TitleMedium(
            text = text,
            dimens = dimens,
            theme = theme,
            color = theme.inflect
        )
    }
}