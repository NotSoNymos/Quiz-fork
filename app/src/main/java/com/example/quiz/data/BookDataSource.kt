package com.example.quiz.data

import com.example.quiz.data.model.Book
import com.example.quiz.data.model.Paragraph

class BookDataSource {
    fun loadNotes(): List<Book> {
        return listOf<Book>(
            Book(
                title = "Title",
                description = "Description",
                list = listOf<Paragraph>(Paragraph("", ""))
            )
        )
    }
}