package com.example.quiz.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.quiz.data.model.Paragraph
import java.util.UUID

@Entity(tableName = "book_tbl")
data class BookEntity(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val list: List<Paragraph>
)
