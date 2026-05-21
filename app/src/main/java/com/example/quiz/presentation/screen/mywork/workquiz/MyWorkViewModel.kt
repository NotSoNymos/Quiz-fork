package com.example.quiz.presentation.screen.mywork.workquiz

import androidx.lifecycle.ViewModel
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import com.example.quiz.repository.QuizRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class MyWorkViewModel @Inject constructor(
    //private val quizRepository: QuizRepository
) :
    ViewModel() {

    private val _listQuiz = MutableStateFlow(
        listOf(
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
            ),
            Quiz(
                "Quiz",
                "quiz",
                listOf(
                    Question("", "", listOf(""))
                )
            )
        )

    )
    val listQuiz: StateFlow<List<Quiz>> = _listQuiz

    fun onListQuizChange(newListQuiz: List<Quiz>) {
        _listQuiz.value = newListQuiz
    }
}