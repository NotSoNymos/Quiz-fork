package com.example.quiz.presentation.screen.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.quiz.presentation.composables.EditLoginRegistration
import com.example.quiz.presentation.composables.EditPasswordRegistration
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.presentation.composables.SimpleCreateBackground
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel()
) {
    val password by viewModel.password.collectAsState()
    val login by viewModel.login.collectAsState()
    SimpleCreateBackground(modifier = Modifier, "Вход", rememberNavController())
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Box(modifier = Modifier.padding(top = 140.dp)) {
            EditLoginRegistration(
                Modifier.padding(top = 150.dp), "Логин",
                login,
                onTextChange = viewModel::onLoginChange
            )
        }


        Box(modifier = Modifier.padding(top = 16.dp)) {
            EditPasswordRegistration(
                "Пароль",
                password,
                onTextChange = viewModel::onPasswordChange
            )
        }

        SimpleButton(
            modifier = Modifier
                .padding(top = 315.dp)
                .width(368.dp)
                .height(77.dp),
            "Войти",
            {})
    }


}

@Preview
@Composable
private fun LoginScreenPreview() {
    QuizTheme { LoginScreen() }
}