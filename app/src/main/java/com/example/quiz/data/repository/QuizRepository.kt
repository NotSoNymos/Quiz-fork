package com.example.quiz.data.repository

import com.example.quiz.data.database.dao.QuizDatabaseDao
import com.example.quiz.data.database.entity.QuizEntity
import com.example.quiz.data.model.Quiz
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject
import kotlin.uuid.Uuid

class QuizRepository @Inject constructor(
    private val quizDatabaseDao: QuizDatabaseDao
) {
    suspend fun addQuiz(quiz: Quiz) {
        val quizEntity = QuizEntity(
            id = quiz.id,
            title = quiz.title,
            description = quiz.description,
            questions = quiz.questions
        )

        quizDatabaseDao.insertQuiz(quizEntity)
    }

    suspend fun deleteQuiz(uuid: UUID) {
        val quizEntity = quizDatabaseDao.getQuizById(uuid.toString())

        quizDatabaseDao.deleteQuiz(quizEntity)
    }

    suspend fun updateQuiz(quiz: Quiz) {
        val quizEntity = QuizEntity(
            id = quiz.id,
            title = quiz.title,
            description = quiz.description,
            questions = quiz.questions
        )

        quizDatabaseDao.updateQuiz(quizEntity)
    }

    fun getAllQuiz(): Flow<List<Quiz>> {
        return quizDatabaseDao.getAllQuiz().flowOn(Dispatchers.IO).map {
            val list = mutableListOf<Quiz>()

            it.forEach { quiz ->
                list.add(
                    Quiz(
                        id = quiz.id,
                        title = quiz.title,
                        description = quiz.description,
                        questions = quiz.questions,
                    )
                )
            }

            return@map list.toList()
        }.conflate()
    }
}