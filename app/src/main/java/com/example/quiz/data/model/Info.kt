package com.example.quiz.data.model

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

data class Info(
    val modifier: Modifier,
    val text: String,
    val label: String,
    val onTextChange: (String) -> Unit,
    val color: Color
)
