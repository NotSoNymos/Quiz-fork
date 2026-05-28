package com.example.quiz.presentation.screen.create.createbook.createbook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.data.model.Book
import com.example.quiz.data.model.Paragraph
import com.example.quiz.domain.repository.DomainRepositoryImpl
import com.example.quiz.presentation.screen.create.createbook.InputParagraph
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID

@HiltViewModel(assistedFactory = CreateBookViewModel.Factory::class)
class CreateBookViewModel @AssistedInject constructor(
    private val _domainRepositoryImpl: DomainRepositoryImpl,
    @Assisted private val bookFormState: CreateBookFormState,
) : ViewModel() {
    private val _title = MutableStateFlow<String>("")
    val title = _title.asStateFlow()

    private val _listParagraph = MutableStateFlow<List<Paragraph>>(emptyList())
    val listParagraph = _listParagraph.asStateFlow()

//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            _domainRepositoryImpl.getBooks().distinctUntilChanged().collect(){_listParagraph.value = it }
//        }
//    }

    fun submitBook(formState: CreateParagraphFormState) {
        viewModelScope.launch(Dispatchers.IO) {
            val book = Book(
                uuid = UUID.randomUUID(),
                title = bookFormState.title,
                description = bookFormState.description,
                list = listOf(
                    Paragraph(
                        title = formState.title,
                        description = formState.description
                    )
                )
            )
            _domainRepositoryImpl.addBook(book)
        }
    }

    fun onChangeListParagraph(newItem: InputParagraph) {
        _listParagraph.value += Paragraph(newItem.title, newItem.description)
    }

    @AssistedFactory
    interface Factory {
        fun create(bookFormState: CreateBookFormState): CreateBookViewModel
    }
}