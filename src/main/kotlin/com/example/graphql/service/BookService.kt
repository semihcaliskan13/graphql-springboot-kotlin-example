package com.example.graphql.service

import com.example.graphql.model.BookDto
import org.springframework.stereotype.Service

@Service
class BookService {

    fun getById(id: String): BookDto {
        return BookDto.books().filter { it.id == id }.stream().findFirst().orElse(null)
    }
}