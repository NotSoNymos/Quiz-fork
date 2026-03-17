package com.example.quiz.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz.R
import com.example.quiz.ui.theme.Black
import com.example.quiz.ui.theme.DeepAzure
import com.example.quiz.ui.theme.QuizTheme
import com.example.quiz.ui.theme.White
import java.nio.file.WatchEvent

@Composable
fun SimpleButton(modifier: Modifier, text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = White

        )
    }
}

@Composable
fun ButtonAddElementQuiz(modifier: Modifier, title: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(165.dp)
            .height(95.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = Black

        )
    }
}

@Composable
fun ButtonAddParagraph(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(71.dp)
            .clip(shape = CircleShape),
        colors = IconButtonDefaults.iconButtonColors(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Icon(
            modifier = Modifier
                .size(51.dp),
            painter = painterResource((R.drawable.ic_add_quiz)),
            contentDescription = null,
            tint = Black,
        )
    }
}

@Composable
fun ButtonCreate(modifier: Modifier, onClick: () -> Unit, title: String) {
    Button(
        onClick = onClick,
        modifier = modifier
            .width(246.dp)
            .height(163.dp),
        colors = ButtonDefaults.buttonColors(White),
        shape = RoundedCornerShape(20.dp)

    ) {
        Text(
            title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            color = Black
        )

    }
}

@Composable
fun ButtonNotification(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(60.dp),
        colors = IconButtonDefaults.iconButtonColors(MaterialTheme.colorScheme.secondary)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_notification), contentDescription = null,
            modifier = Modifier.size(40.dp)
        )

    }
}




@Preview
@Composable
private fun PrevButtonNotification() {
    MaterialTheme { ButtonNotification { {} } }
}
