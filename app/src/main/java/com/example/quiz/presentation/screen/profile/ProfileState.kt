package com.example.quiz.presentation.screen.profile

data class ProfileState(
    val isLoading: Boolean,
    val formState: ProfileFormState = ProfileFormState()
)
