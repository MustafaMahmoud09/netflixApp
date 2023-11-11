package com.lomu.uielement.element.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

@Composable
fun HomeImage(
    src : Painter,
    description : String,
    modifier: Modifier = Modifier,
    contentScale : ContentScale = ContentScale.Crop
){
    Image(
        painter = src,
        contentDescription = description,
        modifier = modifier
            .fillMaxSize(),
        contentScale = contentScale
    )
}