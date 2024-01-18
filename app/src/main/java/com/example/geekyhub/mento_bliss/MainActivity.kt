package com.example.geekyhub.mento_bliss

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        Handler().postDelayed({
            if (FirebaseAuth.getInstance().currentUser==null) {
                val intent = Intent(this, Sign_Up::class.java)
                startActivity(intent)
            }
            else{
                val intent= Intent(this,MainScreen::class.java)
                startActivity(intent)
            }
            finish()
        },2000)
    }
}