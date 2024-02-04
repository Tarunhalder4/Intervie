package com.example.interview

import com.example.interview.model.BookList
import com.example.interview.model.BookStatus
import retrofit2.Call
import retrofit2.http.GET

interface BookService {
    @GET("/status")
    fun getStatus():Call<BookStatus>

    @GET("/books")
    fun getBookList():Call<BookList>

}