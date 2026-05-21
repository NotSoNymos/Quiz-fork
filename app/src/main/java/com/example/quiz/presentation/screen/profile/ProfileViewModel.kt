package com.example.quiz.presentation.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.domain.repository.DomainRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val _domainRepositoryImpl: DomainRepositoryImpl
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileState())
    val uiState = _uiState.asStateFlow()

    fun submitFormState(formState: ProfileFormState) {
        viewModelScope.launch(Dispatchers.IO) {
            _domainRepositoryImpl.updateUserInfo(
                profile = formState.toUser()
            )
        }
    }

    fun getProfileInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = _domainRepositoryImpl.getUserInfo()

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