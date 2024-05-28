package com.example.bookshelf.network

import com.example.bookshelf.model.BooksData
import com.example.bookshelf.model.Item
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApiService {
    @GET("volumes")
    suspend fun getBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int
    ) : BooksData

    @GET("volumes/{id}/")
    suspend fun getItem(@Path("id") id : String) : Item
}