package com.lomu.uielement.stateScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lomu.uielement.R
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.theme.netflixDimens
import com.lomu.uielement.theme.netflixTheme

@Composable
fun ErrorScreen(
    theme : CustomColors = netflixTheme(),
    dimens : CustomDimens = netflixDimens()
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                theme.background
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(
                id = R.drawable.no_internet
            ),
            contentDescription = "",
            tint = theme.redIcon,
            modifier = Modifier
                .size(dimens.dimen_12.dp)
        )
    }
}