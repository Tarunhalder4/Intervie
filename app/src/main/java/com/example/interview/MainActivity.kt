package com.example.interview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.interview.databinding.ActivityMainBinding
import com.example.interview.databinding.DialogViewBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainBinding.button.setOnClickListener {
            openSimpleDialogBox()
        }
    }

    private fun openSimpleDialogBox() {
        val binding = DialogViewBinding.inflate(layoutInflater)

        val builder = AlertDialog.Builder(this)
            .setIcon(R.drawable.android_24)
            .setTitle("My app")
            .setView(binding.root)
            .setMessage("thi is simple dialog")
            .show()

        binding.submit.setOnClickListener {
            mainBinding.name.text = binding.name.text.toString()
            mainBinding.email.text = binding.email.text.toString()
            builder.hide()
        }
    }

}