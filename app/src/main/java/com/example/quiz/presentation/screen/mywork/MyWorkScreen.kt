package com.example.quiz.presentation.screen.mywork

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
import com.example.quiz.data.model.Quiz
import com.example.quiz.presentation.composables.CardWork
import com.example.quiz.presentation.composables.SimpleCreateBackground
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun MyWorkScreen(modifier: Modifier = Modifier, listQuiz: List<Quiz> = listOf<Quiz>()) {
    SimpleCreateBackground(Modifier, "Мои работы")
    val state = rememberScrollState()
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 150.dp, bottom = 100.dp)
            .fillMaxSize()
            .verticalScroll(state)
    ) {
        items(listQuiz) { item ->
            CardWork(Modifier, item.title, item.description, {}, true)
        }
    }
}

@Preview
@Composable
private fun Prev() {
    QuizTheme {
        MyWorkScreen(
            modifier = Modifier,
            listOf<Quiz>(
                Quiz("Title", "description", listOf()),
                Quiz("Title", "description", listOf()),
                Quiz("Title", "description", listOf()),
                Quiz("Title", "description", listOf())
            )
        )
    }
}