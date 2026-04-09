package com.example.quiz.presentation.screen.read_book

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ReadBookViewModel: ViewModel() {
    private val _title = MutableStateFlow("")
    private val _description = MutableStateFlow("")

    val title: StateFlow<String> = _title
    val description: StateFlow<String> = _description

    fun onTitleChange(newText: String){
        _title.value = newText
    }

}