package com.example.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject
import javax.inject.Named

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var repository:Repository

    @VivoAnotation @Inject lateinit var vivo: Mobile
//    @RedmiAnotation @Inject lateinit var redmi:Mobile
//    @MotoAnotation @Inject lateinit var motorola:Mobile

    @VivoAnotation @Inject lateinit var vivo1: Mobile
//    @RedmiAnotation @Inject lateinit var redmi2:Mobile
//    @MotoAnotation @Inject lateinit var motorola3:Mobile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerComponent.create().inject(this)

        val mobiles = arrayOf(vivo,vivo1)

        mobiles.forEach {
            Util.showMassage(it.toString())
        }



    }
}