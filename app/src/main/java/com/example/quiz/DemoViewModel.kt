package com.example.quiz

import androidx.lifecycle.ViewModel
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import com.example.quiz.data.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@Suppress("RedundantSuspendModifier")
class DemoViewModel: ViewModel() {

    // Primitive storage section
    private val _quizList = MutableStateFlow(
        listOf(
            Quiz(
                id = 0,
                title = "Квиз 1",
                description = "Великолепный вопросник",
                questions = listOf(
                    Question(
                        question = "Сколько дней в неделе?",
                        answer = "7",
                        variableAnswers = listOf("6", "7", "8", "Много")
                    ),
                    Question(
                        question = "Через сколько минут варки среднестатистические спагетти размокают",
                        answer = "7-8",
                        variableAnswers = listOf("4-5", "7-8", "9-10")
                    )
                )
            ),
            Quiz(
                id = 1,
                title = "Квиз 2",
                description = "Прекрасный вопросник",
                questions = listOf(
                    Question(
                        question = "123",
                        answer = "..4?",
                        variableAnswers = listOf("..4?", "5", "6")
                    )
                )
            )
        )
    )

    private val _userProfile = MutableStateFlow(User())

    //Basic CRUD logic
    suspend fun getQuizList(): List<Quiz> {
        return _quizList.value
    }

    suspend fun removeQuiz(id: Int) {
        _quizList.update { it.filter { quiz -> quiz.id != id } }
    }

    suspend fun createQuiz(quiz: Quiz) {
        _quizList.update {
            val list = it.toMutableList()
            list.add(quiz)
            list.toList()
        }
    }

    suspend fun getUserInfo(): User {
        return _userProfile.value
    }

    suspend fun updateUserInfo(profile: User){
        _userProfile.update { profile }
    }
}