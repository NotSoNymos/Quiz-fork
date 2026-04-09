package com.example.quiz.presentation.screen.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.descriptors.PrimitiveKind

class LoginViewModel : ViewModel() {
    private val _login = MutableStateFlow("")
    val login: StateFlow<String> = _login
    private var _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    fun onPasswordChange(newText: String){
        _password.value = newText
    }

    fun onLoginChange(newText: String){
        _login.value = newText
    }


}