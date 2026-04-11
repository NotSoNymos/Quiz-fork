package com.example.quiz.presentation.screen.create.createquiz

import com.example.quiz.data.model.Paragraph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CreateQuizViewModel {
    private val _title = MutableStateFlow("")
    val login: StateFlow<String> = _title
    private var _description = MutableStateFlow("")
    val password: StateFlow<String> = _description

    private var _paragraphs = MutableStateFlow(listOf<Paragraph>())
    val paragraphs: StateFlow<List<Paragraph>> = _paragraphs

    fun onTitleChange(newText: String){
        _title.value = newText
    }

    fun onDescriptionChange(newText: String){
        _description.value = newText
    }

//    fun onParagraphsChange(newParagraph: Paragraph){
//        val newList = _paragraphs.value+ newParagraph
//        _paragraphs.value = newList
//    }

}