package com.visma.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.visma.weather.presentation.R


val LinikSans = FontFamily(
    Font(resId = R.font.liniksans_light, weight = FontWeight.Light),
    Font(
        resId = R.font.liniksans_light_italic,
        weight = FontWeight.Light,
        style = FontStyle.Italic
    ),
    Font(resId = R.font.liniksans_medium, weight = FontWeight.Medium),
    Font(
        resId = R.font.liniksans_medium_italic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic
    ),
    Font(resId = R.font.liniksans_bold, weight = FontWeight.Bold),
    Font(resId = R.font.liniksans_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(resId = R.font.liniksans_black, weight = FontWeight.Black),
    Font(resId = R.font.liniksans_bold_italic, weight = FontWeight.Black, style = FontStyle.Italic)
)


// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = LinikSans,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        color = Color.White
    ),
    bodyLarge = TextStyle(
        fontFamily = LinikSans,
        fontWeight = FontWeight.Black,
        fontSize = 62.sp,
        color = Color.White
    ),
    bodyMedium = TextStyle(
        fontFamily = LinikSans,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        color = Color.White
    ),
    labelSmall = TextStyle(
        fontFamily = LinikSans,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        color = Color.White.copy(alpha = 0.6F)
    ),
)