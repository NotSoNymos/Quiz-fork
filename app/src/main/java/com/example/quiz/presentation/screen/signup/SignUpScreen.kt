package com.example.quiz.presentation.screen.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quiz.presentation.composables.BackgroundLogin

import com.example.quiz.presentation.composables.EditLoginRegistration
import com.example.quiz.presentation.composables.EditPasswordRegistration
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.ui.theme.QuizTheme


@SuppressLint("UnrememberedMutableState")
@Composable
fun SignUpScreen(modifier: Modifier = Modifier, viewModel: SignUpViewModel = viewModel()) {
    BackgroundLogin("Регистрация")
    val password by viewModel.password.collectAsState()
    val password2 by viewModel.password2.collectAsState()
    val login by viewModel.login.collectAsState()
    Column(modifier = Modifier
        .padding(top = 142.dp, start = 17.dp)
        .fillMaxSize()) {
        EditLoginRegistration(
            Modifier.padding(top = 150.dp), "Логин",
            login,
            onTextChange = viewModel::onEmailChange
        )
        EditPasswordRegistration(
            "Пароль",
            password,
            onTextChange = viewModel::onPasswordChange
        )
        EditPasswordRegistration("Повторите пароль",
            password2,
            onTextChange = viewModel::onPassword2Change)
        Box(modifier = Modifier.padding(top = 145.dp)) {
            SimpleButton(
                modifier = Modifier
                    .width(368.dp)
                    .height(77.dp), "Зарегистрироваться"
            ) { }
        }

    }

}

@Preview
@Composable
private fun SignUpScreePreview() {
    QuizTheme { SignUpScreen() }
}