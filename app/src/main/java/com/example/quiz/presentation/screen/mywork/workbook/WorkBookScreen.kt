package com.example.quiz.presentation.screen.mywork.workbook

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.presentation.composables.CardWork
import com.example.quiz.presentation.composables.SimpleCreateBackground
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun MyWorkScreen(
    modifier: Modifier = Modifier,
    viewModel: WorkBookViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    SimpleCreateBackground(Modifier, "Мои работы", navHostController)

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 150.dp, bottom = 100.dp)
            .fillMaxSize()
    ) {
        items(viewModel.listBooks.value) { item ->
            CardWork(Modifier, item.title, item.description, {}, true)
        }
    }
}

@Preview
@Composable
private fun WorkBookPreview() {
    QuizTheme {
        MyWorkScreen(
            modifier = Modifier, navHostController = rememberNavController()
        )
    }
}