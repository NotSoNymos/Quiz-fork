package com.example.quiz.presentation.screen.mywork.workquiz

import androidx.lifecycle.ViewModel
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyWorkViewModel : ViewModel() {

    private val _listQuiz = MutableStateFlow(listOf(Quiz(
        "Quiz",
        "quiz",
        listOf(
            Question("", "", listOf(""))
        )
    ),
        Quiz(
            "Quiz",
            "quiz",
            listOf(
                Question("", "", listOf(""))
            )
        ),
        Quiz(
            "Quiz",
            "quiz",
            listOf(
                Question("", "", listOf(""))
            )
        ))

    )
    val listQuiz: StateFlow<List<Quiz>> = _listQuiz

    fun onListQuizChange(newListQuiz: List<Quiz>) {
        _listQuiz.value = newListQuiz
    }
}