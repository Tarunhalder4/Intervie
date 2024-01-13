package com.example.interview

import android.util.Log
import javax.inject.Inject

class Repository @Inject constructor() {

    fun name(){
        Log.d("tarun", "name: ")
    }
}