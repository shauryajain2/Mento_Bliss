package com.example.geekyhub.mento_bliss

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.geekyhub.mento_bliss.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.conductTestBtn.setOnClickListener(){
            val intent=Intent(this, questionActivity::class.java)
            startActivity(intent)
        }


    }
}