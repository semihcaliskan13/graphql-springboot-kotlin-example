package com.example.graphql.api.resolver

import com.example.graphql.entity.Author
import com.example.graphql.repository.AuthorRepository
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class AuthorMutationResolver @Autowired constructor(
    val authorRepository: AuthorRepository
) : GraphQLMutationResolver {


    fun createAuthor(author: Author): Author {
        return authorRepository.save(author)
    }

    fun updateAuthor(author: Author): Author {
        val existingAuthor: Author = authorRepository.findById(author.id).orElseThrow()
        val updatedFields = mutableMapOf<String, Any>()

        for (field in Author::class.java.declaredFields) {
            field.isAccessible = true

            val existingValue = field.get(existingAuthor)
            val updatedValue = field.get(author)

            if (existingValue != updatedValue && updatedValue != null && updatedValue != "") {
                updatedFields[field.name] = updatedValue
                field.set(existingAuthor, updatedValue)
            }
        }

        val updatedAuthor = authorRepository.save(existingAuthor)
        return authorRepository.save(updatedAuthor)
    }

    fun deleteAuthor(id: String): Unit = authorRepository.deleteById(id)
}