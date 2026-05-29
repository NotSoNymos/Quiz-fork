package com.example.quiz.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Paragraph(
    var title: String = "",
    var description: String = ""
): Parcelable
