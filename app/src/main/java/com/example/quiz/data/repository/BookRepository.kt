package com.example.quiz.data.repository

import com.example.quiz.data.database.dao.BookDatabaseDao
import com.example.quiz.data.database.entity.BookEntity
import com.example.quiz.data.model.Book
import com.example.quiz.data.model.Quiz
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject

class BookRepository @Inject constructor(
    private val bookDatabaseDao: BookDatabaseDao
) {
    suspend fun addBook(book: Book) {
        bookDatabaseDao.insertBook(
            BookEntity(
                title = book.title,
                description = book.description,
                list = book.list
            )
        )
    }

    suspend fun deleteBook(id: String) {
        val bookEntity = bookDatabaseDao.getBookById(UUID.fromString(id))

        bookDatabaseDao.deleteBook(bookEntity)
    }

    suspend fun updateBook(id: String, book: Book) {
        val bookEntity = BookEntity(
            id = UUID.fromString(id),
            title = book.title,
            description = book.description,
            list = book.list
        )
        bookDatabaseDao.updateBook(bookEntity)
    }

    suspend fun getBooks(): Flow<List<Book>> {
        return bookDatabaseDao.getBooks().flowOn(Dispatchers.IO).map {
            val list = mutableListOf<Book>()
            it.forEach { book ->
                list.add(
                    Book(
                        id = book.id,
                        title = book.title,
                        description = book.description,
                        list = book.list,
                    )
                )
            }
            return@map list.toList()
        }.conflate()
    }



    suspend fun getBookById(id: String): Book {
        val bookEntity = bookDatabaseDao.getBookById(UUID.fromString(id))
        return Book(
            id = bookEntity.id,
            title = bookEntity.title,
            description = bookEntity.description,
            list = bookEntity.list
        )
    }
}