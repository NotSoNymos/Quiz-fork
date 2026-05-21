package com.example.quiz.di

import android.content.Context
import androidx.room.Room
import com.example.quiz.data.database.BookDatabaseDao
import com.example.quiz.data.database.QuizDatabase
import com.example.quiz.data.database.QuizDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): QuizDatabase =
        Room.databaseBuilder(
            context,
            QuizDatabase::class.java, "quiz_bd"
        ).fallbackToDestructiveMigrationFrom().build()

    @Singleton
    @Provides
    fun provideQuizDao(quizDatabase: QuizDatabase): QuizDatabaseDao = quizDatabase.quizDao()

    @Singleton
    @Provides
    fun  provideBookDao(quizDatabase: QuizDatabase): BookDatabaseDao = quizDatabase.bookDao()
}