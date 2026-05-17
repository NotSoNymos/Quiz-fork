package com.example.quiz.presentation.screen.create.createquiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz.presentation.composables.SimpleButton

import com.example.quiz.presentation.composables.SimpleOutlinedText
import com.example.quiz.presentation.composables.SimpleQuizBackground
import com.example.quiz.ui.theme.QuizTheme
import com.example.quiz.ui.theme.White

@Composable
fun CreateQuizScreen(modifier: Modifier = Modifier) {
    SimpleQuizBackground(modifier = Modifier, label = "Создать квиз", type = "quiz")
    Column(
        modifier = Modifier
            .padding(top = 160.dp)
            .fillMaxSize()
            .background(color = White, shape = RoundedCornerShape(30.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier.width(346.dp)) {
            SimpleOutlinedText(
                Modifier.padding(top = 41.dp),
                "",
                "Название",
                {},
                MaterialTheme.colorScheme.secondary,
                shape = 20
            )
        }
        Box(modifier = Modifier
            .width(355.dp)
            .height(406.dp)) {
            SimpleOutlinedText(
                Modifier
                    .padding(top = 12.dp)
                    .width(355.dp)
                    .height(406.dp),
                "",
                "Описание",
                {},
                MaterialTheme.colorScheme.primaryContainer,
                shape = 10
            )
        }

        SimpleButton(
            modifier = Modifier
                .padding(top = 31.dp, start = 201.dp),
            text = "Далее"
        ) { }
    }
}

@Preview
@Composable
private fun CreateQuizScreenPreview() {
    QuizTheme { CreateQuizScreen() }
}