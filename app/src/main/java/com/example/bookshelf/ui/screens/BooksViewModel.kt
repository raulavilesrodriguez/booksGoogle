package com.example.bookshelf.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BooksApplication
import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.model.Book
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BooksUiState {
    data class Success(val books: ArrayList<Book>) : BooksUiState
    object Error : BooksUiState
    object  Loading : BooksUiState
}

class BooksViewModel(private val booksRepository : BooksRepository) : ViewModel() {

    var booksUiState : BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    private val booksList : ArrayList<Book> = arrayListOf()

    init {
        getBooks()
    }

    fun getBooks(){
        viewModelScope.launch {
            booksUiState = BooksUiState.Loading
            booksUiState = try {
                val books = booksRepository.getBooks()
                books.items.map{item ->
                    item.id?.let {
                        val book = booksRepository.getBook(it)
                        booksList.add(book)
                    }
                }
                BooksUiState.Success(booksList)
            } catch (e: IOException){
                BooksUiState.Error
            } catch (e: HttpException) {
                BooksUiState.Error
            }
        }
    }

    /**
     * Factory
    */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as BooksApplication)
                val booksRepository = application.container.booksRepository
                BooksViewModel(booksRepository)
            }
        }
    }


}