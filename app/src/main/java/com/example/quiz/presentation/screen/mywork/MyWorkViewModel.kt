package com.example.quiz.presentation.screen.mywork

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyWorkViewModel: ViewModel() {
    private val _works = MutableStateFlow("")
    val works: StateFlow<String> = _works
    private var _password = MutableStateFlow("")
    val password: StateFlow<String> = _password
    private var _password2 = MutableStateFlow("")
    val password2: StateFlow<String> = _password2

    fun onPassword2Change(newText: String){
        _password2.value = newText
    }

    fun onPasswordChange(newText: String){
        _password.value = newText
    }

    fun onEmailChange(newText: String){
        _works.value = newText
    }
}