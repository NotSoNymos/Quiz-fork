package com.example.quiz.data.model

data class Question(
    val question: String,
    val answer: String,
    val variableAnswers: List<String>
)
