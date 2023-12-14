package com.example.graphql.model

data class BookDto(
    val id: String,
    val name: String,
    val pageCount: Int,
    val authorId: String
) {
    companion object {
        @JvmStatic
        fun books(): List<BookDto> = listOf(BookDto("1", "ithaki", 10,"asimov"))
    }


}
