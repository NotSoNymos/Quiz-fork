package com.example.quiz.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.quiz.data.database.entity.BookEntity
import com.example.quiz.data.database.entity.QuizEntity

@Database(
    entities = [QuizEntity::class, BookEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class QuizDatabase: RoomDatabase() {
    abstract fun quizDao(): QuizDatabaseDao
    abstract fun bookDao(): BookDatabaseDao
}