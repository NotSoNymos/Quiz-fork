package com.example.quiz.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.domain.repository.DomainRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppInitializeViewModel @Inject constructor(
    private val _domainRepository: DomainRepositoryImpl
) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            _domainRepository.initializeDefaultUser()
        }
    }
}