package com.example.quiz.repository

import com.example.quiz.data.database.QuizDatabaseDao
import com.example.quiz.data.database.entity.QuizEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class QuizRepository @Inject constructor(
    private val quizDatabaseDao: QuizDatabaseDao
) {
    suspend fun addQuiz(quizEntity: QuizEntity) = quizDatabaseDao.insertQuiz(quizEntity)
    suspend fun deleteQuiz(quizEntity: QuizEntity) = quizDatabaseDao.deleteQuiz(quizEntity)
    suspend fun updateQuiz(quizEntity: QuizEntity) = quizDatabaseDao.updateQuiz(quizEntity)

    fun getAllQuiz(): Flow<List<QuizEntity>> = quizDatabaseDao.getAllQuiz().flowOn(Dispatchers.IO).conflate()
}