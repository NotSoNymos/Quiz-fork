package com.example.quiz.presentation.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz.ui.theme.QuizTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomBarNavigation(modifier: Modifier = Modifier) {

    //Scaffold(mo) {  }
//    Surface(
//        shape = RoundedCornerShape(
//            topStart = 20.dp, topEnd = 20.dp
//        ),
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(73.dp),
//        color = MaterialTheme.colorScheme.primary
//    ) {
//
//        LazyRow(
//            contentPadding = PaddingValues(horizontal = 24.dp),
//            horizontalArrangement = Arrangement.spacedBy(20.dp)
//
//
//        ) {
//            items(categories) { category ->
//                SimpleCardNavigation(
//                    icon = category.icon,
//                    onClick = { category.onClick })
//            }
//        }
//
//
//    }

}

@Preview
@Composable
private fun BottomBarNavigationPreview() {
    QuizTheme {
        Spacer(modifier = Modifier.height(500.dp))
        BottomBarNavigation()
    }
}