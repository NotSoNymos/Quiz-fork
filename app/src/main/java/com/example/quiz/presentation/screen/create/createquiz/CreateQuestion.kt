package com.example.quiz.presentation.screen.create.createquiz

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.quiz.data.model.InputField
import com.example.quiz.presentation.composables.ButtonAddVariableAnswer
import com.example.quiz.presentation.composables.SimpleAnswerText
import com.example.quiz.presentation.composables.SimpleQuizBackground
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun CreateQuestion(modifier: Modifier = Modifier) {
    val fields = remember { mutableStateListOf<InputField>() }
    val question = remember { mutableStateOf("") }
    val answer = remember { mutableStateOf("") }

    SimpleQuizBackground(Modifier, "Создать квиз", "quiz")

    // Вместо Column используем LazyColumn для всего контента

    LazyColumn(
        modifier = Modifier
            .padding(top = 210.dp) // Отступ под шапку
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(bottom = 32.dp) // Отступ снизу, чтобы кнопки не прилипали
    ) {
        // 1. Поле "Вопрос"
        item {
            OutlinedTextField(
                value = question.value,
                onValueChange = { question.value = it },
                modifier = modifier
                    .width(368.dp)
                    .height(63.dp),
                label = {
                    Text(
                        "Вопрос",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 20.sp)
                    )
                },
                shape = RoundedCornerShape(20),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.secondary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.secondary
                )
            )
        }

        // 2. Поле "Правильный ответ"
        item {
            OutlinedTextField(
                value = answer.value,
                onValueChange = { answer.value = it },
                modifier = modifier
                    .padding(top = 25.dp)
                    .width(368.dp)
                    .height(63.dp),
                label = {
                    Text(
                        "Правильный ответ",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 20.sp)
                    )
                },
                shape = RoundedCornerShape(20),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // 3. Список динамических вариантов ответа

        itemsIndexed(fields) { index, field ->
            SimpleAnswerText(
                Modifier.width(355.dp)
                    .padding(vertical = 4.dp),
                field.text,
                 "Вариант №${index + 1}" ,
                {},
                color = MaterialTheme.colorScheme.secondary
            )
        }

        // 4. Кнопки управления
        item {
            ButtonAddVariableAnswer(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .width(368.dp)
                    .height(60.dp),
                { fields.add(InputField(id = fields.size)) },
                "Добавить вариант ответа"
            )

            ButtonAddVariableAnswer(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .width(368.dp)
                    .height(60.dp),
                { /* Логика сохранения */ },
                "Сохранить квиз"
            )
        }
    }
}

@Preview
@Composable
private fun CreateQuestionScreen() {
    QuizTheme { CreateQuestion(Modifier) }
}