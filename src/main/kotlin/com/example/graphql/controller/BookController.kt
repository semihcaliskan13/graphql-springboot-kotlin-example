package com.example.graphql.controller

import com.example.graphql.entity.Author
import com.example.graphql.model.AuthorDto
import com.example.graphql.model.BookDto
import com.example.graphql.service.AuthorService
import com.example.graphql.service.BookService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller


@Controller
class BookController(
    val bookService: BookService,
    val authorService: AuthorService
) {

    private fun getId(ex: () -> Unit): String {
        ex.invoke()
        return "lambda function"
    }

//    @QueryMapping
//    fun bookById(@Argument id: String): BookDto {
//        return bookService.getById(id)
//    }
    @QueryMapping
    fun oneAuthor(@Argument id: String): AuthorDto {
        return authorService.oneAuthor(id)
    }

//    @SchemaMapping
//    fun author(bookDto: BookDto): AuthorDto? {
//        return authorService.getById(bookDto.authorId)
//    }
}