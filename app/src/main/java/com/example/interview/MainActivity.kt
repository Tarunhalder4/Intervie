package com.example.interview

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.interview.databinding.ActivityMainBinding
import com.example.interview.databinding.DialogViewBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val value = intent.getStringExtra("name")
        val value1 = intent.getStringExtra("surname")

        Log.d("tarun" , value.toString())
        Log.d("tarun" , value1.toString())


        mainBinding.button.setOnClickListener {
            openSimpleDialogBox()
        }

        askNotificationPermission()

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.d("tarun", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }
            val msg = task.result
            Log.d("tarun","massage come out"+ msg)
            Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
        })
    }


    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
            // FCM SDK (and your app) can post notifications.
        } else {
            // TODO: Inform user that that your app will not show notifications.
        }
    }

    private fun askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) ==
                PackageManager.PERMISSION_GRANTED
            ) {
                // FCM SDK (and your app) can post notifications.
            } else if (shouldShowRequestPermissionRationale(android.Manifest.permission.POST_NOTIFICATIONS)) {
                // TODO: display an educational UI explaining to the user the features that will be enabled
                //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
                //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
                //       If the user selects "No thanks," allow the user to continue without notifications.
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
            }
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