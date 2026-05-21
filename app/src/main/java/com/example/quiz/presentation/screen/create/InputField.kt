package com.example.quiz.presentation.screen.create

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InputField(
    val id: Int,
    var text: String = ""
) : Parcelable