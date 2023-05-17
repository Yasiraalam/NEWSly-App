package com.example.newsapp.spashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.MainActivity
import com.example.newsapp.R


class SplashScreen : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.splash_screen)




            // we used the postDelayed(Runnable, time) method
            // to send a message with a delayed time.
            //Normal Handler is deprecated , so we have to change the code little bit

            // Handler().postDelayed({
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000) // 3000 is the delayed time in milliseconds.
        }
    }

