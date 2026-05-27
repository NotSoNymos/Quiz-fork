package com.example.quiz.presentation.screen.mywork.workquiz

import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.data.model.Quiz
import com.example.quiz.presentation.composables.CardWork
import com.example.quiz.presentation.composables.SimpleCreateBackground
import com.example.quiz.presentation.navigation.Destinations
import com.example.quiz.ui.theme.QuizTheme
import java.util.UUID

@Composable
fun MyWorkScreen(
    modifier: Modifier = Modifier,
    viewModel: MyWorkViewModel,
    navHostController: NavHostController,
) {
    val uiState by viewModel.uiState.collectAsState()

    MyWorkScreenContent(
        modifier = modifier,
        uiState = uiState,
        navHostController = navHostController,
        onCardNavigateAction = {
            navHostController.navigate(Destinations.ReadQuiz(it))
        }
    )
}

@Composable
fun MyWorkScreenContent(
    modifier: Modifier = Modifier,
    uiState: MyWorkState,
    onCardNavigateAction: (quizId: String) -> Unit = {},
    navHostController: NavHostController,
) {
    SimpleCreateBackground(modifier, "Мои работы", navHostController)

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 150.dp, bottom = 100.dp)
            .fillMaxSize()
    ) {
        items(uiState.quizList) { quiz ->
            CardWork(
                modifier = Modifier, title = quiz.title,
                text = quiz.description,
                onClick = { onCardNavigateAction.invoke(quiz.id.toString()) },
                flagSettings = true
            )
        }
    }
}

@Preview
@Composable
private fun MyWorkPreview() {
    QuizTheme {
        MyWorkScreenContent(
            modifier = Modifier,
            uiState = MyWorkState(
                quizList = listOf(
                    Quiz(
                        UUID.randomUUID(),
                        title = "Превосходный квиз",
                        description = "Описание",
                        questions = listOf()
                    )
                )
            ),
            navHostController = rememberNavController()
        )
    }
}