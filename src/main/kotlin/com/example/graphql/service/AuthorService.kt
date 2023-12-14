package com.example.graphql.service

import com.example.graphql.entity.Author
import com.example.graphql.model.AuthorDto
import com.example.graphql.repository.AuthorRepository
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service


@Service
class AuthorService(
    val authorRepository: AuthorRepository
) {

    fun getById(id: String): AuthorDto? {
        return AuthorDto.authorDtos.stream().filter { authorDto: AuthorDto? -> authorDto!!.id == id }.findFirst().orElse(null)
    }

    fun findAllAuthors(): Iterable<Author> {
        return authorRepository.findAll()
    }

    fun oneAuthor(id: String): AuthorDto {
        val authorDto: AuthorDto = AuthorDto()
        val authorDb: Author = authorRepository.findById(id).get()
        authorDto.id=authorDb.id
        authorDto.firstName = authorDto.firstName
        authorDto.lastName = authorDb.lastName
        authorDto.books = authorDb.books!!


        return authorDto
    }
}