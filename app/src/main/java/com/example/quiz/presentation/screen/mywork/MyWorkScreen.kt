package com.example.quiz.presentation.screen.mywork

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz.presentation.composables.BackgroundProfile
import com.example.quiz.presentation.composables.BottomBarNavigation
import com.example.quiz.presentation.composables.CardWork
import com.example.quiz.presentation.composables.SimpleCreateBackground
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun MyWorkScreen(modifier: Modifier = Modifier) {
    SimpleCreateBackground(Modifier, "Мои работы")
    Column(
        modifier = Modifier
            .padding(top = 130.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardWork(Modifier, "Title", "Text", {}, false)
        //CardWork(Modifier.padding(top = 20.dp), "Title", "Text", {}, false)

        Spacer(Modifier.weight(1f))
        BottomBarNavigation()
    }
}

@Preview
@Composable
private fun Prev() {
    QuizTheme { MyWorkScreen() }

}