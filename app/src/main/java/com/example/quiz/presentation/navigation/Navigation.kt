package com.example.quiz.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quiz.DemoViewModel
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
import com.example.quiz.presentation.screen.profile.ProfileViewModel
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
    demoViewModel: DemoViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Destinations.Home> {
            val myWorkViewModel: MyWorkViewModel =
                viewModel(factory = viewModelFactory {
                    initializer {
                        MyWorkViewModel(demoViewModel)
                    }
                })

            MyWorkScreen(
                modifier = Modifier,
                viewModel = myWorkViewModel,
                navHostController = navController,
            )
        }
        composable<Destinations.CreateQuestion> {
            val createQuizViewModel: CreateQuizViewModel =
                viewModel(factory = viewModelFactory {
                    initializer {
                        CreateQuizViewModel(demoViewModel)
                    }
                })

            CreateQuestion(
                modifier = Modifier,
                viewModel = createQuizViewModel,
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
            val resolvedWorkViewModel: ResolvedWorkViewModel =
                viewModel(factory = viewModelFactory {
                    initializer {
                        ResolvedWorkViewModel(demoViewModel)
                    }
                })

            ResolvedWorkScreen(
                modifier = Modifier,
                viewModel = resolvedWorkViewModel,
                navHostController = navController
            )
        }

        composable<Destinations.Profile> {
            val profileViewModel: ProfileViewModel =
                viewModel(factory = viewModelFactory {
                    initializer {
                        ProfileViewModel(demoViewModel)
                    }
                })

            ProfileScreen(
                modifier = Modifier,
                viewModel = profileViewModel
            )
        }

        composable<Destinations.Login> {
            LoginScreen()
        }

        composable<Destinations.CreateQuiz> {
            CreateQuizScreen(
                modifier = Modifier,
                navHostController = navController
            )
        }

        composable<Destinations.NoConnection> {
            NoConnectionScreen {}
        }

        composable<Destinations.SignUp> {
            val signUpViewModel: SignUpViewModel =
                viewModel(factory = viewModelFactory {
                    initializer {
                        SignUpViewModel(demoViewModel)
                    }
                })

            SignUpScreen(
                modifier = Modifier,
                viewModel = signUpViewModel,
                navHostController = navController
            )
        }

        composable<Destinations.CreateParagraph> {
            val createBookViewModel: CreateBookViewModel =
                viewModel(factory = viewModelFactory {
                    initializer {
                        CreateBookViewModel(demoViewModel)
                    }
                })

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
            val createBookViewModel: CreateBookViewModel =
                viewModel(factory = viewModelFactory {
                    initializer {
                        CreateBookViewModel(demoViewModel)
                    }
                })

            CreateParagraph(
                viewModel = createBookViewModel,
                navHostController = navController,
            )
        }
    }
}