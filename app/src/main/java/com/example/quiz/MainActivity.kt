package com.example.quiz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.quiz.presentation.composables.bars.AppBottomNavigationBar
import com.example.quiz.presentation.navigation.NavigationGraph
import com.example.quiz.ui.theme.QuizTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val demoViewModel = viewModel<DemoViewModel>()

            QuizTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AppBottomNavigationBar(navController)
                    }
                ) {
                    contentPadding ->
                    NavigationGraph(
                        modifier = Modifier
                            .padding(contentPadding)
                            .fillMaxSize(),
                        navController = navController,
                        demoViewModel = demoViewModel,
                    )
                }
            }
        }
    }
}