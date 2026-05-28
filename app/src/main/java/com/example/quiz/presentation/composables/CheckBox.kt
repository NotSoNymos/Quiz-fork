package com.example.quiz.presentation.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SimpleCheckbox(
    modifier: Modifier,
    isChecked: Boolean = false,
    onValueChange: (value: Boolean) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox( modifier = Modifier,
            checked = isChecked,
            onCheckedChange = {
                onValueChange.invoke(it)
            }
        )
    }
}

@Preview
@Composable
private fun CheckBoxPreview() {
    SimpleCheckbox(Modifier, onValueChange = {})
}