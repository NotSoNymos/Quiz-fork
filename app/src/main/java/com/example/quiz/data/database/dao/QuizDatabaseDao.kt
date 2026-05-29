package com.example.quiz.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.quiz.data.database.entity.BookEntity
import com.example.quiz.data.database.entity.QuizEntity
import com.example.quiz.data.model.Quiz
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface QuizDatabaseDao {
    @Query("SELECT * FROM quiz_tbl")
    fun getAllQuiz(): Flow<List<QuizEntity>>

    @Query("SELECT * FROM quiz_tbl WHERE id=:id")
    suspend fun getQuizById(id: UUID?): QuizEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuiz(quizEntity: QuizEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateQuiz(quizEntity: QuizEntity)

    @Delete
    suspend fun deleteQuiz(quizEntity: QuizEntity)

    @Query("SELECT * FROM quiz_tbl WHERE LOWER(title) LIKE '%' || LOWER(:searchQuery) || '%'")
    fun searchQuiz(searchQuery: String): Flow<List<QuizEntity>>
}