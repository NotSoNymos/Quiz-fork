package com.example.quiz.presentation.screen.create

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quiz.R
import com.example.quiz.presentation.composables.ButtonCreate
import com.example.quiz.presentation.navigation.Destinations

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CreateScreen(
    modifier: Modifier = Modifier,navHostController: NavHostController
) {
    Scaffold(containerColor = MaterialTheme.colorScheme.primary) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.create_name),
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 48.sp),
                modifier = Modifier.padding(top = 81.dp)
            )
            Box(modifier = Modifier.padding(top = 52.dp)) {
                ButtonCreate(title = stringResource(R.string.book_name), onClick = {
//                    navHostController.navigate(
//                        Destinations.CreateBookScreen
//                    )
                })
            }
            Box(modifier = Modifier.padding(top = 37.dp)) {
                ButtonCreate(title = stringResource(R.string.quiz_name), onClick = {
                    navHostController.navigate(
                        Destinations.CreateQuiz
                    )
                })
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

//@Preview
//@Composable
//private fun CreateScreenPreview() {
//    QuizTheme { CreateScreen(Modifier) }
//}