package com.example.graphql.entity

import jakarta.persistence.*


@Entity
@Table(name = "author")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String,
    val firstName: String,
    val lastName: String,
    @OneToMany
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    val books: List<Book>? = null
) {

}
