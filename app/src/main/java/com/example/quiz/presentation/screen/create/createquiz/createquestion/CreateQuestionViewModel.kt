package com.example.quiz.presentation.screen.create.createquiz.createquestion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.data.model.Quiz
import com.example.quiz.domain.repository.DomainRepositoryImpl
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID

@HiltViewModel(assistedFactory = CreateQuestionViewModel.Factory::class)
class CreateQuestionViewModel @AssistedInject constructor(
    private val _domainRepositoryImpl: DomainRepositoryImpl,
    @Assisted private val quizId: Int,
) : ViewModel() {
    fun submitQuiz(formState: CreateQuestionFormState){
        viewModelScope.launch(Dispatchers.IO) {
            //TODO: ASSEMBLE WHOLE DATA
            val quiz = Quiz(
                id = UUID.randomUUID(),
                title = formState.question,
                description = formState.answer,
                questions = listOf()
            )

            _domainRepositoryImpl.createQuiz(quiz)
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(quizId: Int): CreateQuestionViewModel
    }
}