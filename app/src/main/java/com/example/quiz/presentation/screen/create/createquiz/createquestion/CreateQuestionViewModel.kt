package com.example.quiz.presentation.screen.create.createquiz.createquestion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.DemoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateQuestionViewModel(
    private val _demoViewModel: DemoViewModel,
    private val quizId: Int,
) : ViewModel() {
    fun submitQuiz(formState: CreateQuestionFormState){
        viewModelScope.launch(Dispatchers.IO) {
            //_demoViewModel.createQuiz(formState.)
        }
    }
}
