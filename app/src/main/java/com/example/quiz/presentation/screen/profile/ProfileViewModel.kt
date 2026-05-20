package com.example.quiz.presentation.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.DemoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val demoViewModel: DemoViewModel
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileState())
    val uiState = _uiState.asStateFlow()

    fun submitFormState(formState: ProfileFormState) {
        viewModelScope.launch(Dispatchers.IO) {
            demoViewModel.updateUserInfo(
                profile = formState.toUser()
            )
        }
    }

    fun getProfileInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = demoViewModel.getUserInfo()

            _uiState.update {
                ProfileState(
                    formState = ProfileFormState().fromUser(result)
                )
            }
        }
    }

    init {
        getProfileInfo()
    }
}