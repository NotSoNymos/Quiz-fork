package com.example.quiz.repository

import com.example.quiz.data.database.BookDatabaseDao
import com.example.quiz.data.database.QuizDatabaseDao
import com.example.quiz.data.database.entity.BookEntity
import com.example.quiz.data.database.entity.QuizEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BookRepository @Inject constructor(
    private val bookDatabaseDao: BookDatabaseDao
) {
    suspend fun addBook(bookEntity: BookEntity) = bookDatabaseDao.insertBook(bookEntity)
    suspend fun deleteBook(bookEntity: BookEntity) = bookDatabaseDao.deleteBook(bookEntity)
    suspend fun updateBook(bookEntity: BookEntity) = bookDatabaseDao.updateBook(bookEntity)

    fun getBooks(): Flow<List<BookEntity>> = bookDatabaseDao.getBooks().flowOn(Dispatchers.IO).conflate()
}