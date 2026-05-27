package com.example.quiz.presentation.screen.create.createquiz

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
//rememberSaveable работает с @Parcelize
@Parcelize
// чтобы навигация работала с классом
@Serializable
data class CreateQuizFormState(
    var title: String = "",
    var description: String = "",
) : Parcelable