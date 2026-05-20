package com.example.quiz.presentation.screen.mywork.workquiz

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import com.example.quiz.DemoViewModel
import com.example.quiz.presentation.composables.CardWork
import com.example.quiz.presentation.composables.SimpleCreateBackground

@Composable
fun MyWorkScreen(
    modifier: Modifier = Modifier,
    viewModel: MyWorkViewModel,
    navHostController: NavHostController,
) {
    SimpleCreateBackground(Modifier, "Мои работы", navHostController)

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

//@Preview
//@Composable
//private fun Prev() {
//    QuizTheme {
//        MyWorkScreen(
//            modifier = Modifier
//        )
//    }
//}