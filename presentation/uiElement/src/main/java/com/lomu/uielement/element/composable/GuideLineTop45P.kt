package com.lomu.uielement.element.composable

import androidx.constraintlayout.compose.ConstraintLayoutBaseScope
import androidx.constraintlayout.compose.ConstraintLayoutScope

fun ConstraintLayoutScope.guideLineTop45P(): ConstraintLayoutBaseScope.HorizontalAnchor {

    return createGuidelineFromTop(.42f)
}