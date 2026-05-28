package com.example.quiz.presentation.screen.read_quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.quiz.presentation.composables.CardTitle
import com.example.quiz.presentation.composables.CardVariableVariant
import com.example.quiz.presentation.composables.ReadBookCard
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
        onNavigateBackAction = { navHostController.popBackStack() },
        onNextQuestionAction = { viewModel.nextQuestion(onQuizCompleteAction = { navHostController.popBackStack() }) },
        onAnswerSelectAction = { index, value -> viewModel.toggleAnswer(index, value) }
    )
}

@Composable
fun ReadQuizScreenContent(
    modifier: Modifier = Modifier,
    uiState: ReadQuizState = ReadQuizState(),
    onNavigateBackAction: () -> Unit = {},
    onNextQuestionAction: () -> Unit = {},
    onAnswerSelectAction: (index: Int, value: Boolean) -> Unit = { _, _ -> }
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
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) MainColumn@
    {
        Column(
            modifier = Modifier.weight(3f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (uiState.isFirstPage) {
                ReadBookCard(
                    modifier = Modifier
                        .height(240.dp),
                    description = uiState.quizDescription,
                    title = uiState.quizTitle
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(bottom = 30.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    SimpleButton(
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .height(60.dp),
                        text = "Начать!",
                        onClick = onNextQuestionAction
                    )
                }
                return@MainColumn
            }

            CardTitle(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .padding(horizontal = 32.dp)
                    .height(60.dp),
                title = uiState.questionText,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(30.dp))

            LazyColumn(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                itemsIndexed(uiState.answerVariants) { index, item ->
                    CardVariableVariant(
                        text = item.first,
                        isChecked = item.second,
                        onValueChange = { onAnswerSelectAction.invoke(index, it) })
                }
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 30.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            SimpleButton(
                modifier = Modifier.height(70.dp),
                text = if (uiState.isLastPage) "Завершить!" else "Следующий вопрос!",
                onClick = onNextQuestionAction
            )
        }
    }

}
@Preview
@Composable
private fun ReadQuizScreenPreview() {
    QuizTheme {
        ReadQuizScreenContent(
            modifier = Modifier,
            uiState = ReadQuizState(
                isFirstPage = false,
                answerVariants = listOf("Ответ 1" to false, "Ответ 2" to true)
            ),
            onNavigateBackAction = {}
        )
    }
}