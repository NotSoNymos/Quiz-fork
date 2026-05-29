package com.example.quiz.presentation.screen.read_book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.data.model.Book
import com.example.quiz.data.model.Paragraph
import com.example.quiz.domain.repository.DomainRepositoryImpl
import com.example.quiz.presentation.screen.read_book.details.ReadBookDetailsState
import com.example.quiz.presentation.screen.read_book.paragraphs.ReadBookParagraphsState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

//TODO: Should be probably splitted into two separate ViewModels....

@HiltViewModel(assistedFactory = ReadBookViewModel.ReadBookViewModelFactory::class)
class ReadBookViewModel @AssistedInject constructor(
    @Assisted private val bookId: String,
    private val _domainRepository: DomainRepositoryImpl,
) : ViewModel() {
    private val _detailsState = MutableStateFlow(ReadBookDetailsState(bookId))
    val detailsState = _detailsState.asStateFlow()
    private val _paragraphState = MutableStateFlow(ReadBookParagraphsState())
    val paragraphState = _paragraphState.asStateFlow()
    private var nextPageIndex: Int = 0
    private var currentBook: Book = Book()

//    fun isLast():Boolean{
//        if (nextPageIndex == )
//    }
    fun readNextPage() {
        viewModelScope.launch(Dispatchers.IO) {
            _paragraphState.update {
                it.copy(
                    title = currentBook.list.getOrElse(nextPageIndex) { Paragraph() }.title,
                    paragraphText = currentBook.list.getOrElse(nextPageIndex) { Paragraph() }.description
                )
            }
            nextPageIndex += 1
        }
    }
    init {
        viewModelScope.launch(Dispatchers.IO) {
            currentBook = _domainRepository.getBookById(bookId)
            _detailsState.update {
                it.copy(
                    title = currentBook.title,
                    description = currentBook.description
                )
            }
            readNextPage()
        }
    }
    @AssistedFactory
    interface ReadBookViewModelFactory {
        fun create(bookId: String): ReadBookViewModel
    }
}