package com.example.quiz.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.quiz.data.database.dao.BookDatabaseDao
import com.example.quiz.data.database.dao.QuizDatabaseDao
import com.example.quiz.data.database.dao.UserDatabaseDao
import com.example.quiz.data.database.entity.BookEntity
import com.example.quiz.data.database.entity.QuizEntity
import com.example.quiz.data.database.entity.UserEntity
import com.example.quiz.data.database.utils.Converters

@Database(
    entities = [QuizEntity::class, BookEntity::class, UserEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class QuizDatabase: RoomDatabase() {
    abstract fun quizDao(): QuizDatabaseDao
    abstract fun bookDao(): BookDatabaseDao
    abstract fun userDao(): UserDatabaseDao
}