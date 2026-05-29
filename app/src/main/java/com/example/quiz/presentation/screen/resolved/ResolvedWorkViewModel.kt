package com.example.quiz.presentation.screen.resolved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.data.model.Book
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import com.example.quiz.domain.repository.DomainRepositoryImpl
import com.example.quiz.presentation.screen.mywork.workquiz.MyWorkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResolvedWorkViewModel @Inject constructor(
    private val _domainRepositoryImpl: DomainRepositoryImpl
) :    ViewModel() {
    private val _uiState = MutableStateFlow(WorkBookState())
    val uiState = _uiState.asStateFlow()
    fun updateBookList(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = _domainRepositoryImpl.getBooks().first()

            _uiState.update { it.copy(bookList = result) }
        }
    }

    fun deleteBook(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _domainRepositoryImpl.deleteBook(id)

            updateBookList()
        }
    }

    init {
        updateBookList()
    }
}