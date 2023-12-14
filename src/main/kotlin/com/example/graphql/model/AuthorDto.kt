package com.example.graphql.model

import com.example.graphql.entity.Book


class AuthorDto(
    var id: String= "",
    var firstName: String = "",
    var lastName: String = "",
    var books: List<Book> = ArrayList()
) {

    //constructor(): this("", "", "")
    companion object {
        val authorDtos = listOf(
            AuthorDto("asimov", "Isaac", "Asimov"),
        )
    }
}