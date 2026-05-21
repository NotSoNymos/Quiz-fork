package com.example.quiz.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.quiz.presentation.composables.bars.AppBottomNavigationBar
import com.example.quiz.presentation.navigation.NavigationGraph
import com.example.quiz.ui.theme.QuizTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            @Suppress("unused", "UnusedVariable")
            val initializeViewModel: AppInitializeViewModel = hiltViewModel()

            QuizTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AppBottomNavigationBar(navController)
                    }
                ) { contentPadding ->
                    NavigationGraph(
                        modifier = Modifier.Companion
                            .padding(contentPadding)
                            .fillMaxSize(),
                        navController = navController,
                    )
                }
            }
        }
    }
}