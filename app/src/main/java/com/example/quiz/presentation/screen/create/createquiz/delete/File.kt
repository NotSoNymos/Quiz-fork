package com.example.quiz.presentation.screen.create.createquiz.delete

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class InputField(
    val id: Int,
    var text: String = ""
)

@Composable
fun DynamicTextFieldsScreen() {
    // Список объектов наших полей
    val fields = remember { mutableStateListOf<InputField>() }

    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = {
            // Добавляем новое пустое поле в список
            fields.add(InputField(id = fields.size))
        }) {
            Text("Добавить поле ввода")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            itemsIndexed(fields) { index, field ->
                OutlinedTextField(
                    value = field.text,
                    onValueChange = { newText ->
                        // Важно: создаем копию объекта или обновляем состояние,
                        // чтобы Compose заметил изменение текста
                        fields[index] = field.copy(text = newText)
                    },
                    label = { Text("Поле №${index + 1}") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                )
            }
        }
    }


}

@Preview
@Composable
private fun PreviewEx() {
    DynamicTextFieldsScreen()
}