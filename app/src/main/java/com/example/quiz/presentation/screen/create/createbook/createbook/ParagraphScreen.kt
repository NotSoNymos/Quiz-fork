@file:JvmName("CreateParagraphScreenKt")

package com.example.quiz.presentation.screen.create.createbook.createbook

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.data.model.Paragraph
import com.example.quiz.presentation.composables.ButtonAddParagraph
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.presentation.composables.SimpleOutlinedText
import com.example.quiz.presentation.composables.SimpleQuizBackground
import com.example.quiz.presentation.navigation.Destinations
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun CreateParagraphContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    onSubmitAction: () -> Unit = {},
    onAddNewParagraph: (Paragraph) -> Unit = {}
) {
    var formState by rememberSaveable { mutableStateOf(Paragraph()) }
    SimpleQuizBackground(modifier = Modifier, "Создать учебник", "book", navHostController)
    Column(
        modifier = Modifier

            .fillMaxSize()
            .padding(top = 160.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SimpleOutlinedText(
            modifier = Modifier
                .padding(top = 20.dp)
                .width(335.dp),
            formState.title,
            "Название",
            { formState = formState.copy(title = it) },
            MaterialTheme.colorScheme.primaryContainer,
            shape = 20
        )

        Box() {
            SimpleOutlinedText(
                modifier = Modifier
                    .width(335.dp)
                    .height(503.dp),
                formState.description,
                "Описание",
                { formState = formState.copy(description = it) },
                MaterialTheme.colorScheme.secondary,
                shape = 10
            )

            ButtonAddParagraph(
                Modifier.padding(top = 470.dp, start = 260.dp),
                {
                    onAddNewParagraph.invoke(Paragraph())
                })

            SimpleButton(
                modifier = Modifier
                    .padding(top = 510.dp)
                    .padding(start = 20.dp, top = 9.dp)
                    .width(226.dp),
                "Сохранить"
            ) {
                onSubmitAction()
                navHostController.navigate(Destinations.Profile)
                //viewModel.submitBook()
            }
        }
    }
}


@Composable
fun CreateParagraph(
    modifier: Modifier = Modifier,
    viewModel: CreateBookViewModel = hiltViewModel(),
    navHostController: NavHostController,
) {
    CreateParagraphContent(
        modifier = Modifier,
        navHostController,
        onSubmitAction = { viewModel.submitBook() },
        onAddNewParagraph = { viewModel.onChangeListParagraph(newItem = it) })
}


@Preview
@Composable
private fun CreateParagraphPreview() {
    QuizTheme { CreateParagraph(navHostController = rememberNavController()) }
}