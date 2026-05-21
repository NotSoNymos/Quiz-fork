package com.example.quiz.presentation.screen.read_quiz

import androidx.lifecycle.ViewModel
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ReadQuizViewModel @Inject constructor(
    //private val quizRepository: QuizRepository
): ViewModel() {
    private val _quiz =
        MutableStateFlow(
            Quiz(
                UUID.randomUUID(),
                "",
                "",
                listOf(Question("Question", "Answer", listOf("Var1", "Var2")))
            )
        )
    val quiz: StateFlow<Quiz> = _quiz

    private val _variants = MutableStateFlow(quiz.value.questions)
    val variants: MutableStateFlow<List<Question>> = _variants


}