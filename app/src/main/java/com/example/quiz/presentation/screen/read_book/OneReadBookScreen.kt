package com.example.quiz.presentation.screen.read_book

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quiz.presentation.composables.ReadBookCard
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.presentation.composables.SimpleQuizBackground
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun OneReadBookScreen(modifier: Modifier = Modifier, viewModel: ReadBookViewModel = viewModel()) {
    SimpleQuizBackground(Modifier, "Чтение ", "book")
    Column(
        modifier = Modifier
            .padding(top = 180.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ReadBookCard(
            description = viewModel.description.collectAsState().value,
            title = viewModel.title.collectAsState().value
        )
        SimpleButton(Modifier.padding(top = 15.dp, start = 160.dp), "Далее") { }
    }
}

@Preview
@Composable
private fun OneReadBookScreenPreview() {
    QuizTheme { OneReadBookScreen(Modifier) }
}