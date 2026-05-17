package com.example.quiz.presentation.screen.mywork.workbook

import androidx.lifecycle.ViewModel
import com.example.quiz.data.model.Book
import com.example.quiz.data.model.Quiz
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WorkBookViewModel: ViewModel() {

    private val _listBooks = MutableStateFlow(listOf(Book("", "", listOf())))

    val listBooks: StateFlow<List<Book>> = _listBooks

    fun onListBookChange(newListBook: List<Book>) {
        _listBooks.value = newListBook
    }
}