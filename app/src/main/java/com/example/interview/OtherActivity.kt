package com.example.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class OtherActivity : AppCompatActivity() {

    @Inject
    @VivoAnotation
    lateinit var vivo:Mobile
    @Inject
    @VivoAnotation
    lateinit var vivo1:Mobile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        (application as Base).component.inject(this)

        val arrayOfMobile = arrayOf(vivo,vivo1)

        arrayOfMobile.forEach {
            Util.showMassage(it.toString())
        }



    }


}