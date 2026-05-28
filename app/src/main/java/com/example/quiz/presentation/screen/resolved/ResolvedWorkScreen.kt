package com.example.quiz.presentation.screen.resolved

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quiz.presentation.composables.CardWork
import com.example.quiz.presentation.composables.SimpleCreateBackground
import com.example.quiz.presentation.navigation.Destinations

@Composable
fun MyWorkScreenBook(
    modifier: Modifier = Modifier,
    viewModel: ResolvedWorkViewModel,
    navHostController: NavHostController,
) {
    val uiState by viewModel.uiState.collectAsState()

    MyWorkScreenBookContent(
        modifier = modifier,
        uiState = uiState,
        navHostController = navHostController,
        onCardNavigateAction = {
            navHostController.navigate(Destinations.ReadBookDetails(it))
        }
    )
}

@Composable
fun MyWorkScreenBookContent(
    modifier: Modifier = Modifier,
    uiState: WorkBookState,
    onCardNavigateAction: (quizId: String) -> Unit = {},
    navHostController: NavHostController,
) {
    SimpleCreateBackground(modifier, "Мои работы", navHostController)

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 150.dp)
            .fillMaxSize()
    ) {
        items(uiState.bookList) {book ->
            CardWork(
                modifier = Modifier, title = book.title,
                text = book.description,
                onClick = { onCardNavigateAction.invoke(book.id.toString()) },
                flagSettings = true
            )
        }
    }
}

//@Preview
//@Composable
//private fun ResolvedWorkPreview() {
//    QuizTheme { ResolvedWorkScreen(Modifier) }
//
//}