package com.example.quiz.presentation.screen.navcontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quiz.data.Destinations
import com.example.quiz.presentation.screen.create.CreateScreen
import com.example.quiz.presentation.screen.login.LoginOrSignUpScreen
import com.example.quiz.presentation.screen.login.LoginScreen
import com.example.quiz.presentation.screen.noconnection.NoConnectionScreen

@Composable
fun NavGraph(navController: NavHostController, changeTheme:()->Unit) {
    NavHost(
        navController = navController,
        startDestination = Destinations.LoginScreen.route,

        ) {
        composable(Destinations.LoginScreen.route) {
            LoginScreen(modifier = Modifier)
        }
        composable(Destinations.CreateScreen.route) {
            CreateScreen(modifier = Modifier)
        }
        composable(Destinations.LoginOrSignUpScreen.route) {
            LoginOrSignUpScreen(modifier = Modifier)
        }
        composable(Destinations.NoConnectionScreen.route) {
            NoConnectionScreen{}
        }
    }
}