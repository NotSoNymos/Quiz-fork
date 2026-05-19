package com.example.quiz.presentation.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.quiz.presentation.composables.BackgroundProfile
import com.example.quiz.presentation.composables.BottomBarNavigation
import com.example.quiz.ui.theme.QuizTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun ProfileScreen(modifier: Modifier = Modifier, viewModel: ProfileViewModel= viewModel()) {
    val image by viewModel.image.collectAsState()
        BackgroundProfile(Modifier, icon = image, {ContentProfileScreen()})

}

@Preview
@Composable
private fun ProfilePreview() {
    QuizTheme { ProfileScreen(modifier = Modifier) }
}