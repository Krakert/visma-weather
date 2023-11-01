package com.visma.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(2.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(8.dp)
)

data class CustomShapes(
    val bottomBarButton: RoundedCornerShape = RoundedCornerShape(20.dp)
)

val LocalShapes = staticCompositionLocalOf { CustomShapes() }
