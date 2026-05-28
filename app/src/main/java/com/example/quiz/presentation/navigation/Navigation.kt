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
import com.example.quiz.presentation.screen.create.createbook.createbook.CreateBookViewModel
import com.example.quiz.presentation.screen.create.createbook.createbook.CreateParagraph
import com.example.quiz.presentation.screen.create.createbook.createbook.CreateBookFormState
import com.example.quiz.presentation.screen.create.createquiz.CreateQuizFormState
import com.example.quiz.presentation.screen.create.createquiz.CreateQuizScreen
import com.example.quiz.presentation.screen.create.createquiz.delete.CreateQuizViewModel
import com.example.quiz.presentation.screen.create.createquiz.createquestion.CreateQuestionScreen
import com.example.quiz.presentation.screen.create.createquiz.createquestion.CreateQuestionViewModel
import com.example.quiz.presentation.screen.login.LoginScreen
import com.example.quiz.presentation.screen.mywork.workquiz.MyWorkScreen
import com.example.quiz.presentation.screen.mywork.workquiz.MyWorkViewModel
import com.example.quiz.presentation.screen.noconnection.NoConnectionScreen
import com.example.quiz.presentation.screen.profile.ProfileScreen
import com.example.quiz.presentation.screen.profile.ProfileViewModel
import com.example.quiz.presentation.screen.read_book.ReadBookViewModel
import com.example.quiz.presentation.screen.read_book.details.ReadBookDetailsScreen
import com.example.quiz.presentation.screen.read_book.paragraphs.ReadBookParagraphsScreen
import com.example.quiz.presentation.screen.read_quiz.ReadQuizScreen
import com.example.quiz.presentation.screen.read_quiz.ReadQuizViewModel
import com.example.quiz.presentation.screen.resolved.MyWorkScreenBook
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
            // currentBackStack.toRoute преобразовать в текущее значение
            // .toRoute позволяет собрать значения в CreateQuestion
            // пытается вернуть , то что в скобках
            // восстанавливает значения предыдущего класса
            val route = currentBackStack.toRoute<Destinations.CreateQuestion>()

            // создание ViewModel с доп параметром
            val createQuestionViewModel: CreateQuestionViewModel =
                hiltViewModel { factory: CreateQuestionViewModel.Factory ->
                    factory.create(
                        CreateQuizFormState(
                            title = route.title,
                            description = route.description
                        )
                    )
                }

            CreateQuestionScreen(
                modifier = Modifier,
                viewModel = createQuestionViewModel,
                navHostController = navController,
            )
        }


        composable<Destinations.CreateBook> {
            CreateBookScreen(modifier = Modifier, navController)
        }

        composable<Destinations.CreateParagraph> { currentBackStack ->
            val route = currentBackStack.toRoute<Destinations.CreateParagraph>()
            val createBookViewModel: CreateBookViewModel =
                hiltViewModel { factory: CreateBookViewModel.Factory ->
                    factory.create(
                        CreateBookFormState(
                            title = route.title,
                            description = route.description
                        )
                    )
                }
            CreateParagraph(
                modifier = Modifier,
                viewModel = createBookViewModel,
                navHostController = navController,

                )
        }


        composable<Destinations.Search> {
            SerchScreen()
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

            MyWorkScreenBook(
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


        composable<Destinations.Paragraph> {
            val createBookViewModel: CreateBookViewModel = hiltViewModel()

            CreateParagraph(
                viewModel = createBookViewModel,
                navHostController = navController,
            )
        }

        composable<Destinations.ReadBookParagraphs> { backStackEntry ->
            val route = backStackEntry.toRoute<Destinations.ReadBookParagraphs>()
            val readBookViewModel: ReadBookViewModel =
                hiltViewModel { factory: ReadBookViewModel.ReadBookViewModelFactory ->
                    factory.create(bookId = route.bookId)
                }

            ReadBookParagraphsScreen(
                viewModel = readBookViewModel,
                modifier = Modifier,
                navHostController = navController
            )
        }

        composable<Destinations.ReadBookDetails> { backStackEntry ->
            val route = backStackEntry.toRoute<Destinations.ReadBookDetails>()
            val readBookViewModel: ReadBookViewModel =
                hiltViewModel { factory: ReadBookViewModel.ReadBookViewModelFactory ->
                    factory.create(bookId = route.bookId)
                }

            ReadBookDetailsScreen(
                viewModel = readBookViewModel,
                modifier = Modifier,
                navHostController = navController,
            )
        }

        composable<Destinations.ReadQuiz> { backStackEntry ->
            val route = backStackEntry.toRoute<Destinations.ReadQuiz>()
            val readQuizViewModel: ReadQuizViewModel =
                hiltViewModel { factory: ReadQuizViewModel.Factory ->
                    factory.create(route.quizId)
                }

            ReadQuizScreen(
                navHostController = navController,
                modifier = Modifier,
                viewModel = readQuizViewModel
            )
        }
    }
}