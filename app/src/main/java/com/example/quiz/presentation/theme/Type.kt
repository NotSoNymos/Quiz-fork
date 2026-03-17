package com.example.quiz.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.quiz.R
import org.w3c.dom.Text

val fredoka = FontFamily(
    Font(R.font.fredoka_semibold, FontWeight.SemiBold),
    Font(R.font.fredoka_regular, FontWeight.Normal),
    Font(R.font.fredoka_bold, FontWeight.Bold),
    Font(R.font.fredoka_medium, FontWeight.Medium)
)
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp
    ),
    titleMedium = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.Medium,
        fontSize = 36.sp
    ),
    labelLarge = TextStyle(
        fontFamily =  fredoka,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp
    ),
    labelSmall = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.SemiBold,
        fontSize = 40.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp
    ),
    bodySmall = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    )

)