package com.example.quiz.presentation.screen.mywork.workquiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.quiz.DemoViewModel
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MyWorkViewModel(
    private val demoViewModel: DemoViewModel
) : ViewModel() {
    private val _uiState = MutableStateFlow(MyWorkState())

    val uiState = _uiState.asStateFlow()

    fun updateQuizList(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = demoViewModel.getQuizList()

            _uiState.update { it.copy(quizList = result) }
        }
    }

    init {
        updateQuizList()
    }
}