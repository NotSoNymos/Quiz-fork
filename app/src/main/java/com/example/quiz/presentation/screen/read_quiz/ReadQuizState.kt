package com.example.quiz.presentation.screen.read_quiz

data class ReadQuizState(
    val isFirstPage: Boolean = true,
    val isLastPage: Boolean = false,
    val answerVariants: List<Pair<String, Boolean>> = listOf(),
    val questionText: String = "",

    val quizTitle: String = "",
    val quizDescription: String = "",
)
