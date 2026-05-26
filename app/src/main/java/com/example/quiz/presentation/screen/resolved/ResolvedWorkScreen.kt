package com.example.quiz.presentation.screen.resolved

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quiz.presentation.composables.CardWorkBook
import com.example.quiz.presentation.composables.CardWorkQuiz
import com.example.quiz.presentation.composables.SimpleCreateBackground

@Composable
fun ResolvedWorkScreen(
    modifier: Modifier = Modifier,
    viewModel: ResolvedWorkViewModel,
    navHostController: NavHostController,
) {
    SimpleCreateBackground(Modifier, "Решенные \n квизы", navHostController)

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 150.dp)
                .fillMaxSize()
        ) {
            items(viewModel.quizList.value) { item ->
                CardWorkBook(Modifier, item, {}, count = "10" )
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