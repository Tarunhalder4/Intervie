package com.example.interview

import android.app.Application


//@HiltAndroidApp
class Base:Application() {

    lateinit var component:Component
    override fun onCreate() {
        super.onCreate()

        component = DaggerComponent.create()

    }

}