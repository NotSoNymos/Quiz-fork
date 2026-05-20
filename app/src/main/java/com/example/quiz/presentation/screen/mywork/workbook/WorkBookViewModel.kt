package com.example.quiz.presentation.screen.mywork.workbook

import androidx.lifecycle.ViewModel
import com.example.quiz.data.model.Book
import com.example.quiz.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class WorkBookViewModel @Inject constructor(
    private val bookRepository: BookRepository
) : ViewModel() {

    private val _listBooks =
        MutableStateFlow(listOf(Book(title = "", description = "", list = listOf())))

    val listBooks: StateFlow<List<Book>> = _listBooks

    fun onListBookChange(newListBook: List<Book>) {
        _listBooks.value = newListBook
    }

}