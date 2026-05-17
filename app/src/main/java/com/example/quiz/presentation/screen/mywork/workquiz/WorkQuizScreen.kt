package com.example.quiz.presentation.screen.mywork.workquiz

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quiz.data.model.Quiz
import com.example.quiz.presentation.composables.CardWork
import com.example.quiz.presentation.composables.SimpleCreateBackground
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun MyWorkScreen(modifier: Modifier = Modifier, viewModel: MyWorkViewModel = viewModel()) {
    SimpleCreateBackground(Modifier, "Мои работы")

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 150.dp, bottom = 100.dp)
            .fillMaxSize()
    ) {
        items(viewModel.listQuiz.value) { item ->
            CardWork(Modifier, item.title, item.description, {}, true)
        }
    }
}

@Preview
@Composable
private fun Prev() {
    QuizTheme {
        MyWorkScreen(
            modifier = Modifier
        )
    }
}