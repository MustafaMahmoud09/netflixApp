package com.lomu.uielement.element.composable

import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope
import androidx.constraintlayout.compose.ConstraintLayoutScope

@Composable
fun ConstraintLayoutScope.GuideLineEnd33P()
        : ConstraintLayoutBaseScope.VerticalAnchor {

    return createGuidelineFromEnd(.33f)
}