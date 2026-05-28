package com.example.quiz.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.quiz.data.database.entity.QuizEntity
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
}