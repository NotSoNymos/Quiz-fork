package com.example.quiz.presentation.screen.signup

import androidx.lifecycle.ViewModel
import com.example.quiz.domain.repository.DomainRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val _domainRepositoryImpl: DomainRepositoryImpl
) : ViewModel() {
    private val _login = MutableStateFlow("")
    val login: StateFlow<String> = _login
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
        _login.value = newText
    }


//    fun ValidPassword(password: String) : Boolean {
//        if (isStrongPassword(password)){
//            _password = password
//            return true
//        }
//        return false
//    }
//
//    fun ValidEmail(email:String): Boolean{
//        if(isValidEmail(email)){
//            _login = login
//            return true
//        }
//        return false
//    }


}