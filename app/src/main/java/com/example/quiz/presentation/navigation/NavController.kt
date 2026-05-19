package com.example.quiz.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quiz.presentation.composables.NavigationBar
import com.example.quiz.presentation.screen.create.CreateScreen
import com.example.quiz.presentation.screen.create.createbook.CreateBookScreen
import com.example.quiz.presentation.screen.create.createbook.CreateParagraph
import com.example.quiz.presentation.screen.create.createquiz.CreateQuizScreen
import com.example.quiz.presentation.screen.login.LoginScreen
import com.example.quiz.presentation.screen.noconnection.NoConnectionScreen
import com.example.quiz.presentation.screen.profile.ProfileScreen
import com.example.quiz.presentation.screen.resolved.ResolvedWorkScreen
import com.example.quiz.presentation.screen.search.SerchScreen
import com.example.quiz.presentation.screen.signup.SignUpScreen
import kotlinx.serialization.Serializable


@Serializable
sealed class Destinations(val route:String){
    data object LoginScreen: Destinations("login_screen")
    data object CreateQuizScreen: Destinations("create_quiz_screen")
    data object LoginOrSignUpScreen: Destinations("login_or_sign_up_screen")
    data object CreateScreen: Destinations("create_screen")
    data object SignUpScreen: Destinations("sign_up_screen")
    data object SearchScreen: Destinations("search_screen")
    data object ResolvedWorkScreen: Destinations("resolved_work_screen")
    data object ProfileScreen: Destinations("profile_screen")
    data object NoConnectionScreen: Destinations("no_connection_screen")
    data object NavigationBar: Destinations("navigation_bar")
    data object CreateBookScreen: Destinations("create_book_screen")
    data object ParagraphScreen: Destinations("paragraph_screen")
}

@Composable
fun NavGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(navController, startDestination = Destinations.NavigationBar.route, modifier = Modifier) {
        composable(Destinations.ProfileScreen.route) {
            ProfileScreen()
        }
        composable(Destinations.SearchScreen.route) {
            SerchScreen()
        }
        composable(Destinations.LoginScreen.route) {
            LoginScreen()
        }
        composable(Destinations.CreateQuizScreen.route) {
            CreateQuizScreen()
        }
        composable(Destinations.NoConnectionScreen.route) {
            NoConnectionScreen {}
        }
        composable(Destinations.ResolvedWorkScreen.route) {
            ResolvedWorkScreen()
        }
        composable(Destinations.SignUpScreen.route) {
            SignUpScreen()
        }
        composable(Destinations.CreateScreen.route) {
            CreateScreen(Modifier,navController)
        }
        composable(Destinations.NavigationBar.route) {
            NavigationBar(Modifier)
        }
        composable(Destinations.CreateBookScreen.route) {
            CreateBookScreen(Modifier, navHostController = navController)
        }
        composable(Destinations.ParagraphScreen.route) {
            CreateParagraph(Modifier)
        }
    }
}