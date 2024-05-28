package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BooksApiService
import com.example.bookshelf.model.BooksData

interface BooksRepository {

    suspend fun getBooks(): BooksData
    suspend fun getBook(id : String) : Book
}

/**
 * Network Implementation
 */
class DefaultBooksRepository(
    private val booksApiService: BooksApiService
) : BooksRepository {

    override suspend fun getBooks(): BooksData = booksApiService.getBooks("jazz+history", 40)
    override  suspend fun getBook(id: String): Book {
        val item = booksApiService.getItem(id)
        return Book(
            id = item.id,
            imageLink = item.volumeInfo?.imageLinks?.thumbnail,
            title = item.volumeInfo?.title,
            previewLink = item.volumeInfo?.previewLink
        )
    }



}
