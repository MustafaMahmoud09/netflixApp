package com.lomu.uielement.element.composable

import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope
import androidx.constraintlayout.compose.ConstraintLayoutScope

@Composable
fun ConstraintLayoutScope.guideLineTop405P()
        : ConstraintLayoutBaseScope.HorizontalAnchor {

    return createGuidelineFromTop(.375f)
}