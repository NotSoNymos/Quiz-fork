package com.example.quiz.data.model

import java.util.UUID

data class Quiz(
    val id: UUID = UUID.randomUUID(),
    val title: String = "",
    val description: String = "",
    val questions: List<Question> = listOf(),
)
