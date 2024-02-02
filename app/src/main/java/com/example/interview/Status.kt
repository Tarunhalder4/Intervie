package com.example.interview

sealed class Status<T>{

    class Success<T>(val data:T):Status<T>()
    class Loading<T>:Status<T>()
    class Error<T>(val error:String):Status<T>()
}