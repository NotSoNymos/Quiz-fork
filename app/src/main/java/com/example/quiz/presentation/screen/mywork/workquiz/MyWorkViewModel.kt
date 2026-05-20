package com.example.quiz.presentation.screen.mywork.workquiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quiz.DemoViewModel
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyWorkViewModel(
    private val demoViewModel: DemoViewModel
) : ViewModel() {

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