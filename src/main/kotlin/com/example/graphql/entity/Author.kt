package com.example.graphql.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*


@Entity
@Table(name = "author")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String,
    val firstName: String,
    val lastName: String?,

    /**
     * If we don't use DTO, we will set it to EAGER. Otherwise, if u want to fetch books it will throw an exception.
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    val books: List<Book>? = null
) {

}
