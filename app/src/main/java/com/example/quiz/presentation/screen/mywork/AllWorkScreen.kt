package com.example.quiz.presentation.screen.mywork

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz.R
import com.example.quiz.presentation.composables.ButtonCreate
import com.example.quiz.ui.theme.QuizTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AllWorkScreen(modifier: Modifier = Modifier) {
    Scaffold(containerColor = MaterialTheme.colorScheme.primary) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Посмотреть",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 48.sp),
                modifier = Modifier.padding(top = 81.dp)
            )
            Box(modifier = Modifier.padding(top = 52.dp)) {
                ButtonCreate(title = "Квиз", onClick = {
//                    navHostController.navigate(
//                        Destinations.CreateBookScreen
//                    )
                })
            }
            Box(modifier = Modifier.padding(top = 37.dp)) {
                ButtonCreate(title = "Учебник", onClick = {})
            }
            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(R.drawable.dog),
                contentDescription = null,
                modifier = Modifier.width(304.dp),
                contentScale = ContentScale.Crop
            )

        }


    }
}

@Preview
@Composable
private fun AllWorkScreenPreview() {
    QuizTheme { AllWorkScreen() }
}