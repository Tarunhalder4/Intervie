package com.example.interview.model

class Result<T>(val status:Status? = null,
                val data:T? = null,
                val error:String? = null)

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}