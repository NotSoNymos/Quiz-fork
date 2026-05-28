package com.example.quiz.data

import com.example.quiz.data.model.Book
import com.example.quiz.data.model.Paragraph
import java.util.UUID

class BookDataSource {
    fun loadNotes(): List<Book> {
        return listOf<Book>(
            Book(
                id = UUID.randomUUID(),
                title = "Title",
                description = "Description",
                list = listOf<Paragraph>(Paragraph("", "")),
            )
        )
    }
}