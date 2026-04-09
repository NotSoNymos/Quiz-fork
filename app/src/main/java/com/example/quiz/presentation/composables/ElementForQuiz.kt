package com.example.quiz.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz.data.model.Quiz
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun CardForChecked(modifier: Modifier = Modifier, title: String) {
    Row(modifier = Modifier
        .width(346.dp)
        .height(68.dp), horizontalArrangement = Arrangement.SpaceBetween){
        SimpleCheckbox(Modifier.padding(start = 11.dp))
        Text(text = title, modifier = Modifier.padding(end = 250.dp))
    }
}

@Preview
@Composable
private fun CardCheckBoxPreview() {
    QuizTheme { CardForChecked(Modifier,"Title") }
}