package com.example.bookshelf

import android.app.Application
import com.example.bookshelf.data.BooksContainer
import com.example.bookshelf.data.DefaultAppContainer

class BooksApplication : Application() {
    lateinit var  container: BooksContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}