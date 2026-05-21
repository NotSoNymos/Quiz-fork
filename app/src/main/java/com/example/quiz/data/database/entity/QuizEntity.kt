package com.example.quiz.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.quiz.data.model.Question
import java.util.UUID

@Entity(tableName = "quiz_tbl")
data class QuizEntity(
    @PrimaryKey
    val id: UUID= UUID.randomUUID(),
    val title: String,
    val description: String,
    val questions: List<Question>)

