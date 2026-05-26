package com.example.quiz.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.quiz.presentation.screen.create.CreateScreen
import com.example.quiz.presentation.screen.create.createbook.CreateBookScreen
import com.example.quiz.presentation.screen.create.createbook.CreateBookViewModel
import com.example.quiz.presentation.screen.create.createbook.CreateParagraph
import com.example.quiz.presentation.screen.create.createquiz.CreateQuizFormState
import com.example.quiz.presentation.screen.create.createquiz.CreateQuizScreen
import com.example.quiz.presentation.screen.create.createquiz.CreateQuizViewModel
import com.example.quiz.presentation.screen.create.createquiz.createquestion.CreateQuestionScreen
import com.example.quiz.presentation.screen.create.createquiz.createquestion.CreateQuestionViewModel
import com.example.quiz.presentation.screen.login.LoginScreen
import com.example.quiz.presentation.screen.mywork.workquiz.MyWorkScreen
import com.example.quiz.presentation.screen.mywork.workquiz.MyWorkViewModel
import com.example.quiz.presentation.screen.noconnection.NoConnectionScreen
import com.example.quiz.presentation.screen.profile.ProfileScreen
import com.example.quiz.presentation.screen.profile.ProfileViewModel
import com.example.quiz.presentation.screen.read_book.OneReadBookScreen
import com.example.quiz.presentation.screen.read_book.ReadBookViewModel
import com.example.quiz.presentation.screen.resolved.ResolvedWorkScreen
import com.example.quiz.presentation.screen.resolved.ResolvedWorkViewModel
import com.example.quiz.presentation.screen.search.SerchScreen
import com.example.quiz.presentation.screen.signup.SignUpScreen
import com.example.quiz.presentation.screen.signup.SignUpViewModel


@Composable
fun NavigationGraph(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: Destinations = Destinations.Home,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Destinations.Home> {
            val myWorkViewModel: MyWorkViewModel = hiltViewModel()

            MyWorkScreen(
                modifier = Modifier,
                viewModel = myWorkViewModel,
                navHostController = navController,
            )
        }
        composable<Destinations.CreateQuestion> { currentBackStack ->
            val route = currentBackStack.toRoute<Destinations.CreateQuestion>()

            val createQuestionViewModel: CreateQuestionViewModel =
                hiltViewModel { factory: CreateQuestionViewModel.Factory ->
                    factory.create(CreateQuizFormState(title = route.title, description = route.description))
                }

            CreateQuestionScreen(
                modifier = Modifier,
                viewModel = createQuestionViewModel,
                navHostController = navController,
            )
        }

        composable<Destinations.Search> {
            SerchScreen()
        }

        composable<Destinations.Create> {
            CreateScreen(
                modifier = Modifier,
                navHostController = navController,
            )
        }

        composable<Destinations.Look> {
            val resolvedWorkViewModel: ResolvedWorkViewModel = hiltViewModel()

            ResolvedWorkScreen(
                modifier = Modifier,
                viewModel = resolvedWorkViewModel,
                navHostController = navController
            )
        }

        composable<Destinations.Profile> {
            val profileViewModel: ProfileViewModel = hiltViewModel()

            ProfileScreen(
                modifier = Modifier,
                viewModel = profileViewModel
            )
        }

        composable<Destinations.Login> {
            LoginScreen()
        }

        composable<Destinations.CreateQuiz> {
            val viewModel: CreateQuizViewModel = hiltViewModel()
            CreateQuizScreen(
                modifier = Modifier,
                viewModel = viewModel,
                navHostController = navController
            )
        }

        composable<Destinations.NoConnection> {
            NoConnectionScreen {}
        }

        composable<Destinations.SignUp> {
            val signUpViewModel: SignUpViewModel = hiltViewModel()

            SignUpScreen(
                modifier = Modifier,
                viewModel = signUpViewModel,
                navHostController = navController
            )
        }

        composable<Destinations.CreateParagraph> {
            val createBookViewModel: CreateBookViewModel = hiltViewModel()

            CreateParagraph(
                modifier = Modifier,
                viewModel = createBookViewModel,
                navHostController = navController,
            )
        }

        composable<Destinations.CreateBook> {
            CreateBookScreen(
                modifier = Modifier,
                navHostController = navController
            )
        }

        composable<Destinations.Paragraph> {
            val createBookViewModel: CreateBookViewModel = hiltViewModel()

            CreateParagraph(
                viewModel = createBookViewModel,
                navHostController = navController,
            )
        }

        composable<Destinations.ReadBook> { backStackEntry ->
            val route = backStackEntry.toRoute<Destinations.ReadBook>()
            val readBookViewModel: ReadBookViewModel =
                hiltViewModel { factory: ReadBookViewModel.ReadBookViewModelFactory ->
                    factory.create(bookId = route.bookId)
                }

            OneReadBookScreen(
                viewModel = readBookViewModel,
                modifier = Modifier,
                navHostController = navController
            )
        }
    }
}