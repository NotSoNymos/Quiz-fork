package com.example.quiz.presentation.screen.create.createquiz

import androidx.lifecycle.ViewModel
import com.example.quiz.DemoViewModel
import com.example.quiz.data.model.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CreateQuizViewModel(demoViewModel: DemoViewModel) : ViewModel(){
    private val _title = MutableStateFlow("")
    val login: StateFlow<String> = _title

    private var _description = MutableStateFlow("")
    val password: StateFlow<String> = _description

    private var _questions = mutableListOf<Question>()
    val paragraphs: MutableList<Question> = _questions

    fun onTitleChange(newText: String){
        _title.value = newText
    }

    fun onDescriptionChange(newText: String){
        _description.value = newText
    }

    fun onQuestionAdd(newQuestion:Question){
        _questions.add(newQuestion)
    }

//    fun onParagraphsChange(newParagraph: Paragraph){
//        val newList = _paragraphs.value+ newParagraph
//        _paragraphs.value = newList
//    }

}