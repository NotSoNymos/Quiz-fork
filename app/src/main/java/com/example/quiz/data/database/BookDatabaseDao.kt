package com.example.quiz.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.quiz.data.database.entity.BookEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDatabaseDao {
    @Query("SELECT * FROM book_tbl")
    fun getBooks(): Flow<List<BookEntity>>

    @Query("SELECT * FROM book_tbl WHERE id=:id")
    suspend fun getBookById(id: String): BookEntity

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertBook(bookEntity: BookEntity)

    @Update(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun updateBook(bookEntity: BookEntity)

    @Delete
    suspend fun deleteBook(bookEntity: BookEntity)
}