package com.example.quiz.presentation.screen.read_quiz

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.data.model.Question
import com.example.quiz.presentation.composables.CardVariableVariant
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.presentation.composables.SimpleQuizBackground
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun ReadQuizScreen(
    modifier: Modifier = Modifier,
    viewModel: ReadQuizViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val state by viewModel.uiState.collectAsState()

    ReadQuizScreenContent(
        modifier = modifier,
        uiState = state,
        onNavigateBackAction = { navHostController.popBackStack() }
    )
}

@Composable
fun ReadQuizScreenContent(
    modifier: Modifier = Modifier,
    uiState: ReadQuizState = ReadQuizState(),
    onNavigateBackAction: () -> Unit,
) {
    SimpleQuizBackground(
        modifier = modifier,
        label = "Решить квиз",
        type = "quiz",
        onNavigateBackAction = onNavigateBackAction
    )
    Column(
        modifier = Modifier
            .padding(top = 168.dp)
            .fillMaxSize()
    )
    {
        Spacer(modifier = Modifier.height(60.dp))
        
        LazyColumn(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            items(uiState.variants) { item ->
                CardVariableVariant(text = item.question)
            }
        }
        SimpleButton(modifier = Modifier.padding(start = 210.dp), text = "Начать!") { }
    }
}
@Preview
@Composable
private fun ReadQuizScreenPreview() {
    QuizTheme {
        ReadQuizScreenContent(
            modifier = Modifier,
            uiState = ReadQuizState(
                variants = listOf(
                    Question(
                        question = "Question",
                        answer = "Answer 1",
                        variableAnswers = listOf("Answer 1", "Answer 2")
                    ),
                    Question(
                        question = "Question 2",
                        answer = "Answer 2",
                        variableAnswers = listOf("Answer 1", "Answer 2")
                    )
                )
            ),
            onNavigateBackAction = {}
        )
    }
}