package com.example.quiz.presentation.screen.create.createbook

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InputParagraph(
    val id: Int = 1,
    val title: String="",
    val description: String=""
): Parcelable