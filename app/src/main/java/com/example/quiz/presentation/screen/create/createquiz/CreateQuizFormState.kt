package com.example.quiz.presentation.screen.create.createquiz

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class CreateQuizFormState(
    var title: String = "123",
    var description: String = "",
) : Parcelable