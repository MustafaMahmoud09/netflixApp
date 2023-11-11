package com.lomu.uielement.element.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SpacerBackground(
    color: Color
){
    Spacer(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
    )
}