package com.example.quiz.presentation.screen.create.createquiz.createquestion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import com.example.quiz.domain.repository.DomainRepositoryImpl
import com.example.quiz.presentation.screen.create.createquiz.CreateQuizFormState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID

@HiltViewModel(assistedFactory = CreateQuestionViewModel.Factory::class)
class CreateQuestionViewModel @AssistedInject constructor(
    private val _domainRepositoryImpl: DomainRepositoryImpl,
    @Assisted private val quizFormState: CreateQuizFormState,
) : ViewModel() {
    fun submitQuiz(formState: CreateQuestionFormState){
        viewModelScope.launch(Dispatchers.IO) {
            //TODO: ASSEMBLE WHOLE DATA, REWRITE QUESTION LIST
            val quiz = Quiz(
                id = UUID.randomUUID(),
                title = quizFormState.title,
                description = quizFormState.description,
                questions = listOf(
                    Question(
                        question = formState.question,
                        answer = formState.answer,
                        variableAnswers = formState.fields.map { it.text }
                    )
                )
            )

            _domainRepositoryImpl.createQuiz(quiz)
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(quizFormState: CreateQuizFormState): CreateQuestionViewModel
    }
}