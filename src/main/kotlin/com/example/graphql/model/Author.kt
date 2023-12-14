package com.example.graphql.model

class Author(val id: String,  val firstName: String,  val lastName: String) {

    companion object {
        val authors = listOf(
            Author("asimov", "Isaac", "Asimov"),
        )
    }
}