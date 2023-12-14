package com.example.graphql.service

import com.example.graphql.model.Book
import org.springframework.stereotype.Service

@Service
class BookService {

    fun getById(id: String): Book {
        return Book.books().filter { it.id == id }.stream().findFirst().orElse(null)
    }
}