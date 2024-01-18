package com.example.geekyhub.mento_bliss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class About_us : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        supportActionBar?.hide()
    }
}