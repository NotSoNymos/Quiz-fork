package com.example.quiz.presentation.screen.create.createbook

import androidx.lifecycle.ViewModel
import com.example.quiz.DemoViewModel
import com.example.quiz.data.model.Paragraph
import com.example.quiz.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CreateBookViewModel @Inject constructor(
    private val _demoViewModel: DemoViewModel
): ViewModel() {
    private val _isChecked = MutableStateFlow(false)
    val isChecked: StateFlow<Boolean> = _isChecked
    private val _title = MutableStateFlow("")
    val login: StateFlow<String> = _title
    private var _description = MutableStateFlow("")
    val password: StateFlow<String> = _description

    private var _paragraphs = MutableStateFlow(listOf<Paragraph>())
    val paragraphs: StateFlow<List<Paragraph>> = _paragraphs

    fun onTitleChange(newText: String){
        _title.value = newText
    }
    fun onIsCheckedChange(newStatus: Boolean){
        _isChecked.value = newStatus
    }
    fun onDescriptionChange(newText: String){
        _description.value = newText
    }

    fun onParagraphsChange(newParagraph: Paragraph){
        val newList = _paragraphs.value+ newParagraph
        _paragraphs.value = newList
    }
    fun LookParagraphs(): MutableStateFlow<List<Paragraph>> {
        return _paragraphs;
    }
}