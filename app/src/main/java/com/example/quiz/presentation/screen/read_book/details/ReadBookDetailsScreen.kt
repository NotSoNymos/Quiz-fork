package com.example.quiz.presentation.screen.read_book.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quiz.presentation.composables.CardTitle
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.presentation.composables.SimpleQuizBackground
import com.example.quiz.presentation.navigation.Destinations
import com.example.quiz.presentation.screen.read_book.ReadBookViewModel
import com.example.quiz.ui.theme.QuizTheme


@Composable
fun ReadBookDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: ReadBookViewModel,
    navHostController: NavHostController,
) {
    val state by viewModel.detailsState.collectAsState()

    ReadBookDetailsContent(
        modifier = modifier,
        uiState = state,
        onNavigateBackAction = { navHostController.popBackStack() },
        onNavigateNextAction = { navHostController.navigate(Destinations.ReadBookParagraphs(state.bookId)) }
    )
}

@Composable
fun ReadBookDetailsContent(
    modifier: Modifier = Modifier,
    uiState: ReadBookDetailsState,
    onNavigateBackAction: () -> Unit,
    onNavigateNextAction: () -> Unit,
) {
    SimpleQuizBackground(
        modifier = Modifier,
        label = "Чтение ",
        type = "book",
        onNavigateBackAction = onNavigateBackAction
    )
    Column(
        modifier = modifier
            .padding(top = 180.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardTitle(
            Modifier
                .width(346.dp)
                .height(71.dp), uiState.title,
            color = MaterialTheme.colorScheme.primary
        )

        CardTitle(
            Modifier
                .padding(top = 20.dp)
                .width(346.dp)
                .height(371.dp), uiState.description,
            color = MaterialTheme.colorScheme.secondary
        )

        SimpleButton(
            modifier = Modifier.padding(top = 30.dp, start = 160.dp),
            text = "Начать чтение!",
            onClick = onNavigateNextAction
        )
    }
}

@Preview
@Composable
private fun ReadDescriptionBookPreview() {
    QuizTheme {
        ReadBookDetailsContent(
            Modifier,
            ReadBookDetailsState(title = "Лукоморье", description = "А.С. Пушкин"),
            {},
            {},
        )
    }
}