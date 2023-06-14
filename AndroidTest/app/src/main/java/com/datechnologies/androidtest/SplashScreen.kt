package com.datechnologies.androidtest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class SplashScreen : Activity() {

    private var splashTimeOut = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Handler().postDelayed(
                {
                    startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                    finish()
                }, splashTimeOut.toLong())
    }
}