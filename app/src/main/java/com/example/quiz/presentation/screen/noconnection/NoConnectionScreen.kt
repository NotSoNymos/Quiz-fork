package com.example.quiz.presentation.screen.noconnection

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz.R
import com.example.quiz.ui.theme.Black
import com.example.quiz.ui.theme.QuizTheme
import com.example.quiz.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoConnectionScreen(onClick:()->Unit) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Column(Modifier.fillMaxSize()) {
            Icon(
                painter = painterResource(R.drawable.ic_left),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 55.dp, start = 20.dp)
                    .size(43.dp).clickable(onClick=onClick),
                tint = White

            )

            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                Column(
                    modifier = Modifier
                        .padding(
                            start = 41.dp,
                            end = 41.dp,
                            bottom = 167.dp,
                            top = 77.dp
                        )
                        .fillMaxSize()
                        .background(color = White, shape = RoundedCornerShape(20.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.no_connection_image),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 33.dp, end = 33.dp, top = 85.dp)
                            .height(301.dp)
                            .width(255.dp)
                            ,
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = "Нет интернет \n" + "соединения",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Black,
                        modifier = Modifier.padding(), textAlign = TextAlign.Center
                    )
                }


            }
        }
    }

}

@Preview
@Composable
private fun NoConnectionPrev() {
    QuizTheme { NoConnectionScreen({}) }

}