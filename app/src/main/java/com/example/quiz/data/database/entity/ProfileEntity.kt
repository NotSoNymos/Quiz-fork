package com.example.quiz.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "profile_tbl")
data class ProfileEntity(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val surname: String,
    val name: String,
    val patronymic: String,
    val gender: String,
    val age: String,
    val education: String,
    val town: String
)
