package com.example.interview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.interview.databinding.ActivityMainBinding
import javax.inject.Inject

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var repository:Repository
    private lateinit var binding: ActivityMainBinding

    @VivoAnotation @Inject lateinit var vivo: Mobile
//    @RedmiAnotation @Inject lateinit var redmi:Mobile
//    @MotoAnotation @Inject lateinit var motorola:Mobile

    @VivoAnotation @Inject lateinit var vivo1: Mobile
//    @RedmiAnotation @Inject lateinit var redmi2:Mobile
//    @MotoAnotation @Inject lateinit var motorola3:Mobile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        (application as Base).component.inject(this)

        val mobiles = arrayOf(vivo,vivo1)

        mobiles.forEach {
            Util.showMassage(it.toString())
        }

        goToOtherActivity(binding)

    }

    private fun goToOtherActivity(binding: ActivityMainBinding){
        binding.button.setOnClickListener {
            startActivity(Intent(this@MainActivity,OtherActivity::class.java))
        }
    }
}