package com.example.quiz.presentation.screen.read_book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.data.model.Book
import com.example.quiz.data.model.Paragraph
import com.example.quiz.domain.repository.DomainRepositoryImpl
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = ReadBookViewModel.ReadBookViewModelFactory::class)
class ReadBookViewModel @AssistedInject constructor(
    @Assisted private val bookId: String,
    private val _domainRepository: DomainRepositoryImpl,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ReadBookState())
    val uiState = _uiState.asStateFlow()

    private var nextPageIndex: Int = 0
    private var currentBook: Book = Book()

    fun readNextPage() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                it.copy(
                    title = currentBook.title,
                    paragraphText = currentBook.list.getOrElse(nextPageIndex) { Paragraph() }.description
                )
            }
            nextPageIndex += 1
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            currentBook = _domainRepository.getBookById(bookId)
            readNextPage()
        }
    }

    @AssistedFactory
    interface ReadBookViewModelFactory {
        fun create(bookId: String): ReadBookViewModel
    }
}