package com.example.quiz.presentation.composables


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.R
import com.example.quiz.presentation.screen.profile.ContentProfileScreen
import com.example.quiz.ui.theme.QuizTheme
import com.example.quiz.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackgroundLogin(title: String, navHostController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(top = 80.dp, start = 5.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyLarge, color = White,
                        modifier = Modifier.fillMaxWidth(),

                        )
                }, navigationIcon = {
                    IconButton(onClick = {navHostController.popBackStack()}, modifier = Modifier.padding(start = 20.dp)) {
                        Icon(
                            painter = painterResource(R.drawable.ic_left),
                            contentDescription = null,
                            modifier = Modifier
                                .width(43.dp)
                                .height(34.dp), tint = White

                        )
                    }

                })
        },
        containerColor = MaterialTheme.colorScheme.primary
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(
                    color = White,
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
        ) {

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SimpleQuizBackground(modifier: Modifier = Modifier, label: String, type: String, navHostController: NavHostController) {
    Scaffold(containerColor = MaterialTheme.colorScheme.primary, topBar = {
        TopAppBar(
            title = {
                Row(
                    modifier = Modifier
                        .padding(end = 25.dp, top = 42.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        label,
                        modifier = Modifier
                            .padding(start = 17.dp)
                            .width(140.dp),
                        color = White,
                        textAlign = TextAlign.Center

                    )
                    Image(
                        painter = painterResource(if (type == "book") R.drawable.create_book else R.drawable.create_quiz),
                        contentDescription = null, modifier = Modifier
                            .width(135.dp)
                            .height(100.dp)
                    )
                }

            },

            navigationIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_left),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 20.dp, top = 55.dp)
                        .width(43.dp)
                        .height(34.dp)
                        .clickable(onClick = { navHostController.popBackStack() }),
                    tint = White
                )
            },
            modifier = Modifier.height(160.dp),
            colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary)
        )
    }) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(
                    color = White,
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
        ) {
        }
    }
}


@Composable
fun BackgroundProfile(
    modifier: Modifier = Modifier,
    icon: Int,
    body: @Composable () -> Unit
) {
    val state = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp)
        ) {
            ButtonNotification(modifier = Modifier.padding(start = 300.dp), {})
            Image(
                painter = painterResource(icon),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 36.dp, start = 142.dp)
                    .size(117.dp)
                    .clip(
                        CircleShape
                    ), contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }
        Column(
            modifier = Modifier

                .padding(top = 55.dp)
                .fillMaxSize()
                .background(
                    color = White,
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
        ) {
            Spacer(Modifier.padding(top = 40.dp))
            body()
        }
    }
}

@Composable
fun SimpleCreateBackground(
    modifier: Modifier = Modifier,
    title: String,
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Box(
            modifier = Modifier
                .padding(top = 46.dp)
                .fillMaxWidth()
        ) {
            IconButton(onClick = {navHostController.popBackStack()}, modifier = Modifier.padding(start = 20.dp)) {
                Icon(
                    painter = painterResource(R.drawable.ic_left),
                    contentDescription = null,
                    modifier = Modifier
                        .width(43.dp)
                        .height(34.dp), tint = White

                )
            }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge, color = White
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(top = 22.dp)
                .fillMaxSize()
                .background(
                    color = White,
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
        ) {

        }
    }
}

//@Preview
//@Composable
//private fun BackgroundLoginPrev() {
//    QuizTheme {
//        BackgroundLogin("Title") {
//            Image(painter = painterResource(R.drawable.not_found), contentDescription = "")
//        }
//    }
//}

@Preview
@Composable
private fun SimpleQuizBackgroundPreview() {
    QuizTheme { SimpleQuizBackground(label = "Создать учебник", type = "quiz", navHostController = rememberNavController()) }

}

@Preview
@Composable
private fun BackgroundProfilePrev() {
    QuizTheme {
        BackgroundProfile(
            Modifier, R.drawable.ic_launcher_background,
            { ContentProfileScreen(Modifier) }
        )
    }
}

@Preview
@Composable
private fun BackgroundSimplePrev() {
    QuizTheme { SimpleCreateBackground(Modifier, "Title", rememberNavController()) }
}