package com.example.quiz.presentation.screen.create.createbook

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.presentation.composables.SimpleOutlinedText
import com.example.quiz.presentation.composables.SimpleQuizBackground
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun CreateBookScreen(modifier: Modifier = Modifier, viewModel: CreateBookViewModel = viewModel(), navHostController: NavHostController) {
    var checked by remember { mutableStateOf(false) }
    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    SimpleQuizBackground(modifier = Modifier, "Создать учебник", "book")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 160.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SimpleOutlinedText(
            modifier = Modifier
                .padding(top = 20.dp)
                .width(355.dp),
            title.value,
            "Название",
            { title.value = it },
            MaterialTheme.colorScheme.primaryContainer,
            shape = 20
        )

        Box() {
            SimpleOutlinedText(
                modifier = Modifier
                    .width(355.dp)
                    .height(300.dp),
                description.value,
                "Описание",
                { description.value = it },
                MaterialTheme.colorScheme.secondary,
                shape = 10
            )
        }

        Row(
            modifier = Modifier
                .padding(start = 20.dp)
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
            Text(text = "Приватный", style = MaterialTheme.typography.bodyMedium)
        }

        SimpleButton(
            modifier = Modifier
                .padding(top = 13.dp)
                .width(226.dp),
            "Далее"
        ) {
            viewModel.onIsCheckedChange(checked)
            viewModel.onTitleChange(title.value)
            viewModel.onDescriptionChange(description.value)
        }
    }
}

@Preview
@Composable
private fun CreateBookPreview() {
    QuizTheme { CreateBookScreen(Modifier, navHostController = rememberNavController()) }

}