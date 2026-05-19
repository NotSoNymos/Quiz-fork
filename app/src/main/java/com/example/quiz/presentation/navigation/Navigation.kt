package com.example.quiz.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quiz.presentation.screen.create.CreateScreen
import com.example.quiz.presentation.screen.create.createbook.CreateBookScreen
import com.example.quiz.presentation.screen.create.createbook.CreateBookViewModel
import com.example.quiz.presentation.screen.create.createbook.CreateParagraph
import com.example.quiz.presentation.screen.create.createquiz.CreateQuestion
import com.example.quiz.presentation.screen.create.createquiz.CreateQuizScreen
import com.example.quiz.presentation.screen.create.createquiz.CreateQuizViewModel
import com.example.quiz.presentation.screen.login.LoginScreen
import com.example.quiz.presentation.screen.mywork.workquiz.MyWorkScreen
import com.example.quiz.presentation.screen.mywork.workquiz.MyWorkViewModel
import com.example.quiz.presentation.screen.noconnection.NoConnectionScreen
import com.example.quiz.presentation.screen.profile.ProfileScreen
import com.example.quiz.presentation.screen.resolved.ResolvedWorkScreen
import com.example.quiz.presentation.screen.resolved.ResolvedWorkViewModel
import com.example.quiz.presentation.screen.search.SerchScreen
import com.example.quiz.presentation.screen.signup.SignUpScreen
import com.example.quiz.presentation.screen.signup.SignUpViewModel


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
            val myWorkViewModel: MyWorkViewModel = viewModel()
            MyWorkScreen(Modifier,myWorkViewModel,navController)
        }
        composable<Destinations.CreateQuestion> {
            val  createQuizViewModel: CreateQuizViewModel = viewModel()
            CreateQuestion(Modifier, createQuizViewModel, navController)
        }

        composable<Destinations.Search> {
            SerchScreen()
        }

        composable<Destinations.Create> {
            CreateScreen(Modifier, navController)
        }

        composable<Destinations.Look> {
            val resolvedWorkViewModel: ResolvedWorkViewModel = viewModel()
            ResolvedWorkScreen(Modifier,resolvedWorkViewModel,navController)
        }

        composable<Destinations.Profile> {
            ProfileScreen()
        }

        composable<Destinations.Login> {
            LoginScreen()
        }

        composable<Destinations.CreateQuiz> {
            CreateQuizScreen(Modifier,navController)
        }

        composable<Destinations.NoConnection> {
            NoConnectionScreen {}
        }

        composable<Destinations.SignUp> {
            val signUpViewModel: SignUpViewModel = viewModel()
            SignUpScreen(Modifier,signUpViewModel,navController)
        }

        composable<Destinations.CreateParagraph> {
            val createBookViewModel: CreateBookViewModel = viewModel()
            CreateParagraph(Modifier, createBookViewModel, navController)
        }

        composable<Destinations.CreateBook> {
            CreateBookScreen(Modifier, navHostController = navController)
        }

        composable<Destinations.Paragraph> {
            val createBookViewModel: CreateBookViewModel = viewModel()
            CreateParagraph(Modifier,createBookViewModel, navController)
        }
    }
}