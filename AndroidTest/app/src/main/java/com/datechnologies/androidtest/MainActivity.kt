package com.datechnologies.androidtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.datechnologies.androidtest.animation.AnimationActivity
import com.datechnologies.androidtest.chat.ChatActivity
import com.datechnologies.androidtest.databinding.ActivityMainBinding
import com.datechnologies.androidtest.login.LoginActivity

/**
 * The main screen that lets you navigate to all other screens in the app.
 *
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = getString(R.string.activity_main_title)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**
         * =========================================================================================
         * INSTRUCTIONS
         * =========================================================================================
         *
         * 1. UI must work on Android phones of multiple sizes. Do not worry about Android Tablets.
         *
         * 2. Use this starter project as a base and build upon it. It is ok to remove some of the
         * provided code if necessary.
         *
         * 3. Read the additional 'TODO' comments throughout the codebase, they will guide you.
         *
         * 3. Please take care of the bug(s) we left for you in the project as well.
         *
         * Thank you and Good luck. -  D & A Technologies
         * =========================================================================================
         */

        binding.chatButton.setOnClickListener { ChatActivity.start(this) }

        binding.loginButton.setOnClickListener { LoginActivity.start(this) }

        binding.animationButton.setOnClickListener { AnimationActivity.start(this) }
        // TODO: Make the UI look like it does in the mock-up
        // TODO: Add a ripple effect when the buttons are clicked
    }
}