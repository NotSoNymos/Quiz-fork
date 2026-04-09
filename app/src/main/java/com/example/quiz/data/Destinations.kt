package com.example.quiz.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quiz.presentation.screen.create.CreateScreen
import com.example.quiz.presentation.screen.login.LoginOrSignUpScreen
import com.example.quiz.presentation.screen.login.LoginScreen
import com.example.quiz.presentation.screen.noconnection.NoConnectionScreen

sealed class Destinations(val route:String){
    data object LoginScreen: Destinations("login_screen")
    data object CreateScreen: Destinations("create_string")
    data object LoginOrSignUpScreen: Destinations("login_or_sign_up_screen")
    data object NoConnectionScreen: Destinations("no_connection_screen")
}

