package com.example.quiz.presentation.screen.read_quiz

import androidx.lifecycle.ViewModel
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import com.example.quiz.repository.QuizRepository
import com.example.quiz.ui.theme.QuizTheme
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
@HiltViewModel
class ReadQuizViewModel @Inject constructor(
    //private val quizRepository: QuizRepository
): ViewModel() {
    private val _quiz =
        MutableStateFlow(
            Quiz(0,"", "", listOf(Question("Question", "Answer", listOf("Var1", "Var2"))))
        )
    val quiz: StateFlow<Quiz> = _quiz

    private val _variants = MutableStateFlow(quiz.value.questions)
    val variants: MutableStateFlow<List<Question>> = _variants


}