package com.example.quiz.presentation.screen.read_book

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quiz.presentation.composables.CardTitle
import com.example.quiz.presentation.composables.SimpleQuizBackground
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun ReadDescriptionBook(modifier: Modifier = Modifier, viewModel: ReadBookViewModel = hiltViewModel(), navHostController: NavHostController) {
    SimpleQuizBackground(Modifier, "Чтение ", "book",navHostController)
    Column(
        modifier = Modifier
            .padding(top = 180.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CardTitle(
            Modifier
                .width(346.dp)
                .height(71.dp),
            "",//viewModel.title.collectAsState().value,
            color = MaterialTheme.colorScheme.primary
        )

        CardTitle(
            Modifier
                .padding(top = 20.dp)
                .width(346.dp)
                .height(371.dp),
            "",//viewModel.description.collectAsState().value,
            color = MaterialTheme.colorScheme.secondary
        )

        SimpleButton(Modifier.padding(top = 30.dp, start = 160.dp), "Далее") { }
    }
}

//@Preview
//@Composable
//private fun ReadDescriptionBookPreview() {
//    QuizTheme { ReadDescriptionBook(Modifier) }
//}