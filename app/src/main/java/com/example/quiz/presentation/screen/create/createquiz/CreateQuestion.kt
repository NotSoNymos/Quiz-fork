package com.example.quiz.presentation.screen.create.createquiz

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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.data.model.InputField
import com.example.quiz.presentation.composables.ButtonAddParagraph
import com.example.quiz.presentation.composables.ButtonAddVariableAnswer
import com.example.quiz.presentation.composables.SimpleAnswerText
import com.example.quiz.presentation.composables.SimpleQuizBackground
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun CreateQuestion(
    modifier: Modifier = Modifier,
    viewModel: CreateQuizViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val fields = remember { mutableStateListOf<InputField>() }
    val question = remember { mutableStateOf("") }
    val answer = remember { mutableStateOf("") }


    val listVariants = mutableListOf<String>()
    SimpleQuizBackground(Modifier, "Создать квиз", "quiz", navHostController)


    LazyColumn(
        modifier = Modifier
            .padding(top = 210.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        item {
            OutlinedTextField(
                value = question.value,
                onValueChange = { question.value = it },
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
                value = answer.value,
                onValueChange = { answer.value = it },
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




        itemsIndexed(fields) { index, field ->
            SimpleAnswerText(
                Modifier
                    .width(355.dp)
                    .height(80.dp)
                    .padding(vertical = 4.dp),
                field.text,
                "Вариант №${index + 1}",
                onTextChange = { newValue ->
                    // Обновляем текст внутри конкретного объекта по индексу
                    fields[index] = field.copy(text = newValue)
                },
                color = MaterialTheme.colorScheme.secondary,
                onDeleteClick = {
                    fields.removeAt(index)
                },

                )
        }


        item {
            ButtonAddVariableAnswer(
                modifier = Modifier
                    .padding(top = 7.dp)
                    .width(355.dp)
                    .height(70.dp),
                { fields.add(InputField(id = fields.size)) },
                "Добавить вариант ответа",
                MaterialTheme.colorScheme.primary
            )

            Box(modifier = Modifier.fillMaxWidth()) {
                ButtonAddParagraph(modifier = Modifier.padding(top = 30.dp, start = 280.dp)) { }
            }

            ButtonAddVariableAnswer(
                modifier = Modifier
                    .padding(top = 90.dp)
                    .width(355.dp)
                    .height(65.dp),
                { },
                "Сохранить квиз",
                MaterialTheme.colorScheme.secondaryContainer
            )
        }
    }
}

@Preview
@Composable
private fun CreateQuestionScreen() {
    QuizTheme { CreateQuestion(Modifier, navHostController = rememberNavController()) }
}