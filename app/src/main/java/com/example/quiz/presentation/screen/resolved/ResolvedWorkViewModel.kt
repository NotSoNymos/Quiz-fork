package com.example.quiz.presentation.screen.resolved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import com.example.quiz.domain.repository.DomainRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResolvedWorkViewModel @Inject constructor(
    private val _domainRepositoryImpl: DomainRepositoryImpl
) : ViewModel() {
    private val _quizList = MutableStateFlow<List<Quiz>>(listOf())
    val quizList: StateFlow<List<Quiz>> = _quizList

    fun getQuizList(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = _domainRepositoryImpl.getQuizList()

            _quizList.update { result }
        }

    }

    init {
        getQuizList()
    }
}