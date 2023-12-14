package com.example.graphql.api.resolver

import com.example.graphql.entity.Author
import com.example.graphql.repository.AuthorRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class AuthorQueryResolver @Autowired constructor(
    val authorRepository: AuthorRepository
) : GraphQLQueryResolver {


    fun getAllAuthors(): List<Author> {
        return authorRepository.findAll()
    }


    fun getAuthorById(id: String): Author {
        return authorRepository.findById(id).orElseThrow()
    }

    fun countAuthors(): Int = authorRepository.count().toInt()


}