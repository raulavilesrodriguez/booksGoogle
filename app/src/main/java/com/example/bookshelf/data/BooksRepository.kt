package com.example.bookshelf.data

import com.example.bookshelf.network.BooksApiService
import com.example.bookshelf.model.BooksData

interface BooksRepository {

    suspend fun getBooks() : BooksData
}

/**
 * Network Implementation
 */
class DefaultBooksRepository(
    private val booksApiService: BooksApiService
) : BooksRepository {
    override  suspend fun getBooks(): BooksData = booksApiService.getBooks("jazz+history")
}
