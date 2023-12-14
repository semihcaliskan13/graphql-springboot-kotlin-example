package com.example.graphql.controller

import com.example.graphql.model.Author
import com.example.graphql.model.Book
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

    @QueryMapping
    fun bookById(@Argument id: String): Book {
        return bookService.getById(id)
    }

    @SchemaMapping
    fun author(book: Book): Author? {
        return authorService.getById(book.authorId)
    }
}