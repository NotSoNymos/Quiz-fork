package com.example.quiz.presentation.screen.create.createquiz.createquestion

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.presentation.composables.ButtonAddParagraph
import com.example.quiz.presentation.composables.ButtonAddVariableAnswer
import com.example.quiz.presentation.composables.SimpleAnswerText
import com.example.quiz.presentation.composables.SimpleQuizBackground
import com.example.quiz.presentation.screen.create.InputField
import com.example.quiz.ui.theme.QuizTheme

// логика выносится отдельно, чтобы превью работал
// screen and content
@Composable
fun CreateQuestionScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: CreateQuestionViewModel,

) {
    CreateQuestionScreenContent(

        modifier = modifier,
        navHostController = navHostController,
        onSubmitAction = { viewModel.submitQuiz() },
        addNewQuestion ={viewModel.addNewQuestion(newQuestion = it)}
    )
}

@Composable
fun CreateQuestionScreenContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    onSubmitAction: () -> Unit = {},
    addNewQuestion :(CreateQuestionFormState) -> Unit = {},
) {
    var formState by rememberSaveable { mutableStateOf(CreateQuestionFormState()) }

    SimpleQuizBackground(
        modifier = Modifier,
        label = "Создать квиз",
        type = "quiz",
        navHostController = navHostController
    )

    LazyColumn(
        modifier = modifier
            .padding(top = 210.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        item {
            OutlinedTextField(
                value = formState.question,
                onValueChange = { formState = formState.copy(question = it) },
                modifier = Modifier
                    .width(355.dp)
                    .height(80.dp),
                label = {
                    Text(
                        "Вопрос",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 24.sp)
                    )
                },
                shape = RoundedCornerShape(20),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.secondary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                    focusedBorderColor = MaterialTheme.colorScheme.secondary
                ),
                textStyle = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 24.sp
                ),
            )
        }

        item {
            OutlinedTextField(
                value = formState.answer,
                onValueChange = { formState = formState.copy(answer = it) },
                modifier = Modifier
                    .padding(top = 25.dp)
                    .width(355.dp)
                    .height(80.dp),
                label = {
                    Text(
                        "Правильный ответ",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 24.sp)
                    )
                },
                shape = RoundedCornerShape(20),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                    focusedBorderColor = MaterialTheme.colorScheme.secondary
                ),
                textStyle = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 24.sp
                ),
            )
            Spacer(modifier = Modifier.height(16.dp))
        }




        itemsIndexed(formState.fields) { index, field ->
            SimpleAnswerText(
                Modifier
                    .width(355.dp)
                    .height(80.dp)
                    .padding(vertical = 4.dp),
                field.text,
                "Вариант №${index + 1}",
                onTextChange = { newValue ->
                    val updatedFields = formState.fields.toMutableList()
                    updatedFields[index] = field.copy(text = newValue)
                    formState = formState.copy(fields = updatedFields)
                },
                color = MaterialTheme.colorScheme.secondary,
                onDeleteClick = {

                    val updatedFields = formState.fields.toMutableList()
                    updatedFields.removeAt(index)
                    formState = formState.copy(fields = updatedFields)
                },
                )
        }


        item {
            ButtonAddVariableAnswer(
                modifier = Modifier
                    .padding(top = 7.dp)
                    .width(355.dp)
                    .height(70.dp),
                {
                    val newFieldId = System.currentTimeMillis().toInt()
                    val newField = InputField(id = newFieldId, text = "")

                    // Добавляем новое поле в список и обновляем стейт формы
                    formState = formState.copy(fields = (formState.fields + newField).toMutableList())
                    //formState. = ""
                    
                },
                "Добавить вариант ответа",
                MaterialTheme.colorScheme.primary
            )

            Box(modifier = Modifier.fillMaxWidth()) {
                ButtonAddParagraph(modifier = Modifier.padding(top = 30.dp, start = 280.dp)) {
                    addNewQuestion.invoke(formState)
                }
            }

            ButtonAddVariableAnswer(
                modifier = Modifier
                    .padding(top = 90.dp)
                    .width(355.dp)
                    .height(65.dp),
                {
                    onSubmitAction()
                },
                "Сохранить квиз",
                MaterialTheme.colorScheme.secondaryContainer
            )
        }
    }
}

@Preview
@Composable
private fun CreateQuestionScreenContentScreen() {
    QuizTheme {
        CreateQuestionScreenContent(
            navHostController = rememberNavController()
        )
    }
}