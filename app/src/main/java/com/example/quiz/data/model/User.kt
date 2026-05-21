package com.example.quiz.data.model

import com.example.quiz.R

data class User(
    var image: Int = R.drawable.dog,
    var surname: String = "",
    var name: String = "",
    var patronymic: String = "",
    var gender: String = "",
    var age: String = "",
    var education: String = "",
    var town: String = "",
)
