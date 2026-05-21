@file:JvmName("CreateParagraphScreenKt")

package com.example.quiz.presentation.screen.create.createbook

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.DemoViewModel
import com.example.quiz.data.model.Paragraph
import com.example.quiz.presentation.composables.ButtonAddParagraph
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.presentation.composables.SimpleOutlinedText
import com.example.quiz.presentation.composables.SimpleQuizBackground
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun CreateParagraph(
    modifier: Modifier = Modifier,
    viewModel: CreateBookViewModel = hiltViewModel(),
    navHostController: NavHostController,
) {
    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    SimpleQuizBackground(modifier = Modifier, "Создать учебник", "book", navHostController )
    Column(
        modifier = Modifier

            .fillMaxSize()
            .padding(top = 160.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SimpleOutlinedText(
            modifier = Modifier.padding(top = 20.dp).width(335.dp),
            title.value,
            "Название",
            { title.value = it },
            MaterialTheme.colorScheme.primaryContainer,
            shape = 20
        )

        Box() {
            SimpleOutlinedText(
                modifier = Modifier
                    .width(335.dp)
                    .height(503.dp),
                description.value,
                "Описание",
                { description.value = it },
                MaterialTheme.colorScheme.secondary,
                shape = 10
            )

            ButtonAddParagraph(
                Modifier.padding(top = 470.dp, start = 260.dp), {

                    title.value = ""
                    description.value = ""
                })

            SimpleButton(
                modifier = Modifier
                    .padding(top = 510.dp)
                    .padding(start = 20.dp, top = 9.dp)
                    .width(226.dp),
                "Сохранить"
            ) {
                viewModel.onParagraphsChange(Paragraph(title.value, description.value))
            }
        }
    }
}


@Preview
@Composable
private fun CreateParagraphPreview() {
    QuizTheme { CreateParagraph(navHostController = rememberNavController(),) }
}

