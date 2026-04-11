package com.example.quiz.presentation.screen.create.createquiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.quiz.presentation.composables.SimpleOutlinedText
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun CreateQuestionScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = 16.dp)
            .width(367.dp)
            .height(583.dp)
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
            MaterialTheme.colorScheme.primaryContainer
        )
        SimpleOutlinedText(
            modifier = Modifier
                .width(367.dp)
                .height(583.dp),
            "",
            "Описание",
            {},
            MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview
@Composable
private fun CreateQuestionPreview() {
    QuizTheme { CreateQuestionScreen() }
}