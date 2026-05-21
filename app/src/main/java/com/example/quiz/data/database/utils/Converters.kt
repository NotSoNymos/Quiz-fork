package com.example.quiz.data.database.utils

import androidx.room.TypeConverter
import com.example.quiz.data.database.entity.BookEntity
import com.example.quiz.data.database.entity.QuizEntity
import com.example.quiz.data.model.Paragraph
import com.example.quiz.data.model.Question
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    // Question
    @TypeConverter
    fun fromQuestionList(value: List<Question>?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toQuestionList(value: String?): List<Question>? {
        val listType = object : TypeToken<List<Question>>() {}.type
        return gson.fromJson(value, listType)
    }

    // Question
    @TypeConverter
    fun fromParagraphList(value: List<Paragraph>?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toParagraphList(value: String?): List<Paragraph>? {
        val listType = object : TypeToken<List<Paragraph>>() {}.type
        return gson.fromJson(value, listType)
    }


    // BookEntity
    @TypeConverter
    fun fromBookEntity(value: BookEntity?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toBookEntity(value: String?): BookEntity? {
        val listType = object : TypeToken<BookEntity>() {}.type
        return gson.fromJson(value, listType)
    }


    // QuizEntity
    @TypeConverter
    fun fromQuizEntity(value: QuizEntity?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toQuizEntity(value: String?): QuizEntity? {
        val listType = object : TypeToken<QuizEntity>() {}.type
        return gson.fromJson(value, listType)
    }


}