package com.example.interview

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    @Singleton
    fun baseUrl(): String{
        return "https://simple-books-api.glitch.me"
    }

    @Provides
    @Singleton
    fun getRetrofit(baseUrl:String):Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun getBookService(retrofit: Retrofit):BookService{
        return retrofit.create(BookService::class.java)
    }

}

