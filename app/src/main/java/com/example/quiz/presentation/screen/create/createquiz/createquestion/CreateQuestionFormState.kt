package com.example.quiz.presentation.screen.create.createquiz.createquestion

import android.os.Parcelable
import com.example.quiz.presentation.screen.create.InputField
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreateQuestionFormState(
    var fields: MutableList<InputField> = mutableListOf<InputField>(),
    var question: String = "",
    var answer: String = "",
): Parcelable
