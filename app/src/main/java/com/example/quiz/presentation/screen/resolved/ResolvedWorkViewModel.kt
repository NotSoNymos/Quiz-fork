package com.example.quiz.presentation.screen.resolved

import androidx.lifecycle.ViewModel
import com.example.quiz.DemoViewModel
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import com.example.quiz.repository.BookRepository
import com.example.quiz.repository.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class ResolvedWorkViewModel(
    private val _demoViewModel: DemoViewModel
) : ViewModel() {
    private val _quizList = MutableStateFlow(
        listOf(
            Quiz(
                0,
                "Title1",
                "Description1",
                listOf(Question("Question", "Answer", listOf("Var1", "Var2")))
            ),
            Quiz(
                1,
                "Title2",
                "Description2",
                listOf(Question("Question", "Answer", listOf("Var1", "Var2")))
            )
        )

    )
    val quizList: StateFlow<List<Quiz>> = _quizList
}