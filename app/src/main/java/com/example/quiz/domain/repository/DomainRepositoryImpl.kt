package com.example.quiz.domain.repository

import com.example.quiz.data.model.Book
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import com.example.quiz.data.model.User
import com.example.quiz.data.repository.BookRepository
import com.example.quiz.data.repository.QuizRepository
import com.example.quiz.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import java.util.UUID
import javax.inject.Inject

class DomainRepositoryImpl @Inject constructor(
    private val _bookRepository: BookRepository,
    private val _quizRepository: QuizRepository,
    private val _userRepository: UserRepository,

): DomainRepository {
    override suspend fun initializeDefaultUser() {
        val defaultUser = User(
            surname = "Default",
            name = "User",
            patronymic = "",
            gender = "Not specified",
            age = "0",
            education = "None",
            town = "Unknown"
        )

        _userRepository.insertUserIfNotExists(defaultUser)
        _quizRepository.addQuiz(
            Quiz(
                id = UUID.fromString("40e8ece3-5a11-4388-95fb-9895afef4bfa"),
                "Проверочный квиз!",
                description = "Описание проверочного квиза!",
                questions = listOf(
                    Question(
                        "Первый вопрос",
                        "Правильный ответ!",
                        listOf(
                            "Неправильный ответ",
                            "Правильный ответ!",
                            "Ещё один неправильный ответ",
                            "Ну точно неправильный ответ"
                        )
                    ),
                    Question(
                        question = "Второй вопрос!",
                        answer = "Точно-точно правильный ответ",
                        variableAnswers = listOf(
                            "Точно-точно правильный ответ",
                            "Может быть неправильный ответ",
                            "Неверный ответ",
                            "Некорректный ответ"
                        )
                    ),
                    Question(
                        question = "Сова!",
                        answer = "Сова",
                        variableAnswers = listOf("Сова", "Сова"),
                    )
                )
            )
        )
    }

    override suspend fun getQuizList(): List<Quiz> {
        val result = _quizRepository.getAllQuiz().first()
        return result
    }

    override suspend fun getQuizById(id: String): Quiz {
        return _quizRepository.getQuizById(id)
    }

    override suspend fun createQuiz(quiz: Quiz) {
        _quizRepository.addQuiz(quiz)
    }

    override suspend fun removeQuiz(id: UUID) {
        _quizRepository.deleteQuiz(id)
    }

    override suspend fun addBook(book: Book) {
        _bookRepository.addBook(book)
    }

    override suspend fun deleteBook(id: String) {
        _bookRepository.deleteBook(id)
    }

    override suspend fun updateBook(id: String, book: Book) {
        _bookRepository.updateBook(id, book)
    }

    override suspend fun getBookById(id: String): Book {
        return _bookRepository.getBookById(id)
    }

    override suspend fun getBooks(): Flow<List<Book>> {
        return _bookRepository.getBooks()
    }

    override suspend fun getUserInfo(): User {
        val result = _userRepository.getUserInfo()

        return result
    }

    override suspend fun updateUserInfo(profile: User) {
        _userRepository.updateUserInfo(profile)
    }

    override suspend fun updateQuiz(quizToSave: Quiz) {
        _quizRepository.updateQuiz(quizToSave)
    }
}