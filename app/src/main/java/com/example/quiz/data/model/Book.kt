package com.example.quiz.data.model

import java.util.UUID

data class Book(
    val id: UUID = UUID.randomUUID(),
    val title: String = "",
    val description: String = "",
    val list: List<Paragraph> = listOf()
)
