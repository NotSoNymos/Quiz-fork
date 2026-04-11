package com.example.quiz.presentation.composables


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz.R
import com.example.quiz.presentation.screen.login.LoginViewModel
import com.example.quiz.ui.theme.Black
import com.example.quiz.ui.theme.Grey
import com.example.quiz.ui.theme.QuizTheme

//@Composable
//fun SimpleOutlinedText(modifier: Modifier = Modifier, title: String, label: String, ) {
//    Column {
//        Text(text = title, style = MaterialTheme.typography.bodyLarge, color = White)
////        OutlinedTextField(
////
////        )
//    }
//}


@Composable
fun SimpleOutlinedText(modifier: Modifier = Modifier,  text: String,label: String,  onTextChange: (String) -> Unit, color: Color) {
    OutlinedTextField(
        textStyle = MaterialTheme.typography.labelSmall.copy(color = Black),
        value = text,
        onValueChange = onTextChange,
        modifier = modifier
            .width(368.dp)
            .height(63.dp),
        label = { Text(text= label, style = MaterialTheme.typography.labelSmall.copy(fontSize = 20.sp)) },
        shape = RoundedCornerShape(20),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = color,
            unfocusedContainerColor = color,
            unfocusedBorderColor = color,
            focusedBorderColor = color
        )
    )
}






@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EditLoginRegistration(
    modifier: Modifier = Modifier,
    label: String, text: String, onTextChange: (String) -> Unit
) {
    Column(modifier = Modifier.width(368.dp)) {
        Text(
            text = label,
            modifier = Modifier.padding(top = 25.dp, bottom = 9.dp),
            style = MaterialTheme.typography.bodyMedium.copy(color = Black, fontSize = 26.sp)
        )

        OutlinedTextField(
            textStyle = MaterialTheme.typography.bodyMedium,
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier
                .width(368.dp)
                .height(70.dp),
            label = { Text("") },
            shape = RoundedCornerShape(20),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                focusedBorderColor = MaterialTheme.colorScheme.secondary
            )
        )
    }
}


@Composable
fun EditPasswordRegistration(label: String, text: String, onTextChange: (String) -> Unit) {
    val passwordVisible = remember { mutableStateOf(false) }
    Column(modifier = Modifier.width(368.dp)) {
        Text(
            text = label,
            modifier = Modifier.padding(top = 25.dp, bottom = 9.dp),
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 26.sp)
        )

        OutlinedTextField(
            textStyle = MaterialTheme.typography.bodyMedium,
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier
                .width(368.dp)
                .height(70.dp),
            label = {
                Text(
                    ""
                )
            },
            visualTransformation = if (passwordVisible.value)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            shape = RoundedCornerShape(20),
            trailingIcon = {
                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(
                        painter = painterResource(id = if (passwordVisible.value) R.drawable.ic_eye else R.drawable.ic_eye_close),
                        contentDescription = ""
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                focusedBorderColor = MaterialTheme.colorScheme.secondary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary
            )
        )
    }
}

//@Preview
//@Composable
//private fun EditPasswordRegistrationPrev() {
//
//    val password = remember { mutableStateOf<String>("") }
//    QuizTheme {
//        EditPasswordRegistration("Password", password = password, onTextChange = {})
//    }
//
//}
//
//@Preview
//@Composable
//private fun EditLoginRegistrationPrev() {
//    val login = remember { mutableStateOf("") }
//    QuizTheme { EditLoginRegistration(modifier = Modifier, "Login", login = login) }
//
//}