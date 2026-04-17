package com.example.quiz.presentation.screen.resolved

import androidx.lifecycle.ViewModel
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ResolvedWorkViewModel : ViewModel() {
    private val _quizList = MutableStateFlow(
        listOf(
            Quiz(
                "Title1",
                "Description1",
                listOf(Question("Question", "Answer", listOf("Var1", "Var2")))
            ),
            Quiz(
                "Title2",
                "Description2",
                listOf(Question("Question", "Answer", listOf("Var1", "Var2")))
            )
        )

    )
    val quizList: StateFlow<List<Quiz>> = _quizList
}