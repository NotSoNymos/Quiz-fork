package com.example.quiz.presentation.navigation

import com.example.quiz.R
import kotlinx.serialization.Serializable

@Serializable
sealed class Destinations(val icon: Int? = null) {
    @Serializable
    data object Home : Destinations(icon = R.drawable.ic_home)

    @Serializable
    data object Login : Destinations()

    @Serializable
    data class CreateQuestion(val id: Int) : Destinations()

    @Serializable
    data object CreateQuiz : Destinations()

    @Serializable
    data object LoginOrSignUpScreen : Destinations()

    @Serializable
    data object Create : Destinations(icon = R.drawable.ic_file_addition)

    @Serializable
    data object SignUp : Destinations()

    @Serializable
    data object Search : Destinations(icon = R.drawable.ic_search)

    @Serializable
    data object Look : Destinations(icon = R.drawable.ic_all_application)

    @Serializable
    data object Profile : Destinations(icon = R.drawable.ic_profile)

    @Serializable
    data object NoConnection : Destinations()

    @Serializable
    data object CreateBook : Destinations()

    @Serializable
    data object CreateParagraph : Destinations()

    @Serializable
    data object Paragraph : Destinations()
}