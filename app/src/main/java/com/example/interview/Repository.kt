package com.example.interview

import com.example.interview.model.BookList
import com.example.interview.model.BookStatus
import retrofit2.Call
import javax.inject.Inject

class Repository @Inject constructor(private val bookService: BookService)  {

    fun getStatus():Call<BookStatus>{
        return bookService.getStatus()
    }

    fun getBooKList():Call<BookList>{
        return bookService.getBookList()
    }


}