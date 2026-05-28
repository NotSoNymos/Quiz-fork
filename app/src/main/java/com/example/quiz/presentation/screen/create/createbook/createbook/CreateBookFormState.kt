package com.example.quiz.presentation.screen.create.createbook.createbook

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class CreateBookFormState(
    var title: String="",
    var description: String=""
) : Parcelable
