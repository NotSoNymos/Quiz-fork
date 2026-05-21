package com.example.quiz.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quiz.ui.theme.Black

@Composable
fun SimpleCheckbox(modifier: Modifier, onValueChange: () -> Unit) {
    var checked by remember { mutableStateOf(false) }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox( modifier = Modifier,
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }
}

@Preview
@Composable
private fun CheckBoxPreview() {
    SimpleCheckbox(Modifier, {})
}