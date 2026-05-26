package com.example.quiz.presentation.screen.read_quiz

import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz

data class ReadQuizState(
    val variants: List<Question> = listOf(),
    val quiz: Quiz = Quiz(),
)
