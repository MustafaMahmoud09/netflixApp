package com.lomu.uielement.element.modifier

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier

@Stable
fun Modifier.homeRatio() = then(Modifier.aspectRatio(2f))