package com.example.quiz.presentation.screen.read_quiz

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quiz.presentation.composables.CardVariableVariant
import com.example.quiz.presentation.composables.SimpleQuizBackground
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.data.model.Question
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.ui.theme.QuizTheme
@Composable
fun ReadQuizScreen(
    modifier: Modifier = Modifier,
    viewModel: ReadQuizViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val variants = viewModel.variants.collectAsState().value
    SimpleQuizBackground(Modifier, label = "Решить квиз", "quiz", navHostController )
    Column(
        modifier = Modifier
            .padding(top = 168.dp)
            .fillMaxSize()
    )
    {
        LazyColumn(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            items(variants) {
                item ->
                //CardVariableVariant(text = item)
            }
        }
        SimpleButton(modifier = Modifier.padding(start = 210.dp), text = "Далее") { }
    }
}
@Preview
@Composable
private fun ReadQuizScreenPreview() {
    QuizTheme { ReadQuizScreen(Modifier, navHostController = rememberNavController()) }
}