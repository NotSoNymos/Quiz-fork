package com.example.quiz.presentation.screen.create.createquiz

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreateQuizFormState(
    var title: String = "",
    var description: String = "",
) : Parcelable