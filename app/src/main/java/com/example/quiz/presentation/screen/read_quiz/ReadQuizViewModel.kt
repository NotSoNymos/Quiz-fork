package com.example.quiz.presentation.screen.read_quiz

import androidx.lifecycle.ViewModel
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ReadQuizViewModel @Inject constructor(
    //private val quizRepository: QuizRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(ReadQuizState())
    val uiState = _uiState.asStateFlow()



    init {

    }
}