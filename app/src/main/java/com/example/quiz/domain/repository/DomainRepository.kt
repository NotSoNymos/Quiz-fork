package com.example.quiz.domain.repository

import com.example.quiz.data.model.Book
import com.example.quiz.data.model.Quiz
import com.example.quiz.data.model.User
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface DomainRepository {
    suspend fun initializeDefaultUser()

    suspend fun getQuizList(): List<Quiz>

    suspend fun createQuiz(quiz: Quiz)
    suspend fun removeQuiz(id: UUID)

    suspend fun addBook(book: Book)
    suspend fun deleteBook(id: String)
    suspend fun updateBook(id: String, book: Book)
    fun getBooks(): Flow<List<Book>>

    suspend fun getUserInfo(): User
    suspend fun updateUserInfo(profile: User)
}