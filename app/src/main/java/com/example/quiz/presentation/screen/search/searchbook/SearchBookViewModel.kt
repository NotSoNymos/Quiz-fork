package com.example.quiz.presentation.screen.search.searchbook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.data.database.entity.BookEntity
import com.example.quiz.domain.repository.DomainRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.collections.emptyList

@HiltViewModel
class SearchBookViewModel @Inject constructor(
    private val _domainRepositoryImpl: DomainRepositoryImpl
) :
    ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    val searchResults: StateFlow<List<BookEntity>> = _searchQuery
        .debounce(300)
        .flatMapLatest { query ->
            if (query.trim().isBlank()) {
                flowOf(emptyList())
            } else {
                _domainRepositoryImpl.searchBook(query)
            }
        }

        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    fun onSearchQueryChanged(newQuery: String) {
        _searchQuery.value = newQuery
    }


    }