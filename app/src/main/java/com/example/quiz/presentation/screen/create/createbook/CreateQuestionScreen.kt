package com.example.quiz.presentation.screen.create.createbook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.presentation.composables.ButtonAddParagraph
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.presentation.composables.SimpleOutlinedText
import com.example.quiz.presentation.composables.SimpleQuizBackground
import com.example.quiz.presentation.navigation.Destinations
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun CreateQuestionScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    SimpleQuizBackground(modifier = Modifier, "Создать учебник", "book", navHostController)
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = modifier
                .padding(top = 209.dp)
                .width(367.dp)
                .height(503.dp)
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(15.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleOutlinedText(
                modifier = Modifier.width(335.dp),
                "",
                "Название",
                {},
                MaterialTheme.colorScheme.primaryContainer,
                shape = 20
            )
            SimpleOutlinedText(
                modifier = Modifier
                    .width(367.dp)
                    .height(403.dp),
                "",
                "Описание",
                {},
                MaterialTheme.colorScheme.secondary,
                shape = 20
            )

        }
        Row(){
            SimpleButton(
                modifier = Modifier
                    .padding(top = 18.dp, start = 70.dp),
                text = "Сохранить"
            ) { navHostController.navigate(Destinations.CreateQuestion) }

            ButtonAddParagraph(modifier = Modifier.padding(10.dp)) { }

        }

    }
}

@Preview
@Composable
private fun CreateQuestionPreview() {
    QuizTheme { CreateQuestionScreen(Modifier, rememberNavController()) }
}