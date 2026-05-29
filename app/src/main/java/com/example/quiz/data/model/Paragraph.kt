package com.example.quiz.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Paragraph(
    val title: String = "",
    val description: String = ""
): Parcelable
