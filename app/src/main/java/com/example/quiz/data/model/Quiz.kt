package com.example.quiz.data.model

data class Quiz(
    val id: Int,
    val title: String,
    val description: String,
    val questions: List<Question>)
