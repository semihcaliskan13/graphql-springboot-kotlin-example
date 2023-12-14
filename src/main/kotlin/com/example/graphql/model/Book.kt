package com.example.graphql.model

data class Book(
    val id: String,
    val name: String,
    val pageCount: Int,
    val authorId: String
) {
    companion object {
        @JvmStatic
        fun books(): List<Book> = listOf(Book("1", "ithaki", 10,"asimov"))
    }


}
