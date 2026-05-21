package com.example.quiz.data.model

import java.util.UUID

data class Quiz(
    val id: UUID,
    val title: String,
    val description: String,
    val questions: List<Question>
)
