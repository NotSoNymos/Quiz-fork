package com.example.quiz.presentation.screen.create.createbook.createbook

import android.os.Parcelable
import com.example.quiz.presentation.screen.create.InputField
import com.example.quiz.presentation.screen.create.createbook.InputParagraph
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreateParagraphFormState(
    val title: String="",
    val description: String="",
    var listParagraph: MutableList<InputParagraph> = mutableListOf<InputParagraph>()
): Parcelable
