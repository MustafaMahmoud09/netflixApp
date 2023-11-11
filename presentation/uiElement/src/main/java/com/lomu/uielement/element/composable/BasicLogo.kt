package com.lomu.uielement.element.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.lomu.uielement.R

@Composable
fun BasicLogo(
    painter: Painter = painterResource(
        id = R.drawable.netflix
    ),
    description : String = "logo",
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .aspectRatio(.5f),
        painter = painter,
        contentDescription = description
    )
}