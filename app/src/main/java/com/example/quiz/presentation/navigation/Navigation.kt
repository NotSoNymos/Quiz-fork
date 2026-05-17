package com.example.quiz.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quiz.presentation.screen.create.CreateScreen
import com.example.quiz.presentation.screen.create.createbook.CreateBookScreen
import com.example.quiz.presentation.screen.create.createbook.CreateParagraph
import com.example.quiz.presentation.screen.create.createquiz.CreateQuizScreen
import com.example.quiz.presentation.screen.login.LoginScreen
import com.example.quiz.presentation.screen.mywork.workquiz.MyWorkScreen
import com.example.quiz.presentation.screen.noconnection.NoConnectionScreen
import com.example.quiz.presentation.screen.profile.ProfileScreen
import com.example.quiz.presentation.screen.resolved.ResolvedWorkScreen
import com.example.quiz.presentation.screen.search.SerchScreen
import com.example.quiz.presentation.screen.signup.SignUpScreen


@Composable
fun NavigationGraph(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: Destinations = Destinations.Home
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Destinations.Home> {
            MyWorkScreen()
        }

        composable<Destinations.Search> {
            SerchScreen()
        }

        composable<Destinations.Create> {
            CreateScreen(Modifier, navController)
        }

        composable<Destinations.Look> {
            ResolvedWorkScreen()
        }

        composable<Destinations.Profile> {
            ProfileScreen()
        }

        composable<Destinations.Login> {
            LoginScreen()
        }

        composable<Destinations.CreateQuiz> {
            CreateQuizScreen()
        }

        composable<Destinations.NoConnection> {
            NoConnectionScreen {}
        }

        composable<Destinations.SignUp> {
            SignUpScreen()
        }

        composable<Destinations.CreateBook> {
            CreateBookScreen(Modifier, navHostController = navController)
        }

        composable<Destinations.Paragraph> {
            CreateParagraph(Modifier)
        }
    }
}