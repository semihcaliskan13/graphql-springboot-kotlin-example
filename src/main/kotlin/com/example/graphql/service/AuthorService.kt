package com.example.graphql.service

import com.example.graphql.model.Author
import org.springframework.stereotype.Service

@Service
class AuthorService {

    fun getById(id: String): Author? {
        return Author.authors.stream().filter { author: Author? -> author!!.id == id }.findFirst().orElse(null)
    }
}