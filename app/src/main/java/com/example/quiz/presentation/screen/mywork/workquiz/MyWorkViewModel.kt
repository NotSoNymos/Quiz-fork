package com.example.quiz.presentation.screen.mywork.workquiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.domain.repository.DomainRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyWorkViewModel @Inject constructor(
    //private val quizRepository: QuizRepository
    private val _domainRepositoryImpl: DomainRepositoryImpl
) :
    ViewModel() {
    private val _uiState = MutableStateFlow(MyWorkState())

    val uiState = _uiState.asStateFlow()

    fun updateQuizList(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = _domainRepositoryImpl.getQuizList()

            _uiState.update { it.copy(quizList = result) }
        }
    }

    init {
        updateQuizList()
    }
}