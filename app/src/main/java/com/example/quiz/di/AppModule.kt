package com.example.quiz.di

import android.content.Context
import androidx.room.Room
import com.example.quiz.data.database.QuizDatabase
import com.example.quiz.data.database.dao.BookDatabaseDao
import com.example.quiz.data.database.dao.QuizDatabaseDao
import com.example.quiz.data.database.dao.UserDatabaseDao
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
            ).fallbackToDestructiveMigrationFrom(true)
            .build()

    @Singleton
    @Provides
    fun provideQuizDao(quizDatabase: QuizDatabase): QuizDatabaseDao = quizDatabase.quizDao()

    @Singleton
    @Provides
    fun  provideBookDao(quizDatabase: QuizDatabase): BookDatabaseDao = quizDatabase.bookDao()

    @Singleton
    @Provides
    fun provideUserDao(quizDatabase: QuizDatabase): UserDatabaseDao = quizDatabase.userDao()
}