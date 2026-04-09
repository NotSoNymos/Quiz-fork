package com.example.quiz.presentation.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz.R
import com.example.quiz.data.model.categories
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