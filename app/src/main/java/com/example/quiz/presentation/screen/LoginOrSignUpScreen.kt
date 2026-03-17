package com.example.quiz.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz.R
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun LoginOrSignUpScreen(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.login_or_signup), contentDescription = null, Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        SimpleButton(modifier = Modifier.padding(top = 336.dp).width(368.dp).height(81.dp), text = "Войти в аккаунт", {})
        SimpleButton(modifier = Modifier.padding(top = 28.dp).width(368.dp).height(81.dp), text = "Зарегистрироваться", ) { }
    }
}

@Preview
@Composable
private fun LoginOrSignUpScreenPrev() {
    QuizTheme {
        LoginOrSignUpScreen()
    }

}