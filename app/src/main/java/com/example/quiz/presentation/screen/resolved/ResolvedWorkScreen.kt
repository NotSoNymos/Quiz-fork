package com.example.quiz.presentation.screen.resolved

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.quiz.presentation.composables.CardWork
import com.example.quiz.presentation.composables.CardWorkQuiz
import com.example.quiz.presentation.composables.SimpleCreateBackground
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun ResolvedWorkScreen(modifier: Modifier = Modifier, viewModel: ResolvedWorkViewModel= viewModel(), navHostController: NavHostController) {
    SimpleCreateBackground(Modifier, "Мои работы", navHostController)
    Column(modifier = Modifier.fillMaxSize()) {
        val state = rememberScrollState()
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 150.dp, bottom = 100.dp)
                .fillMaxSize()
        ) {
            items(viewModel.quizList.value) { item ->
                CardWorkQuiz(Modifier, item, {}, count = "10" )
            }

        }
    }
}

//@Preview
//@Composable
//private fun ResolvedWorkPreview() {
//    QuizTheme { ResolvedWorkScreen(Modifier) }
//
//}