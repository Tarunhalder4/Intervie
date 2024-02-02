package com.example.interview

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel :ViewModel() {

    private val _personState = MutableStateFlow(Person())

}

data class Person(val name:String? = null,
                  val age:Int? = null,
                  val occupation:String? = null)