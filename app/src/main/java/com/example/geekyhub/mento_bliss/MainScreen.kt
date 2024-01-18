package com.example.geekyhub.mento_bliss

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView
import com.example.geekyhub.mento_bliss.databinding.ActivityHomeBinding

class MainScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        supportActionBar?.hide()

        val test = findViewById<Button>(R.id.conduct_test)
        test.setOnClickListener(){
            val intent= Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        val playlist = findViewById<Button>(R.id.specialist)
        playlist.setOnClickListener(){
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://www.google.com/maps/search/psychiatrist+near+me/@28.6825986,77.2657815,11z/data=!3m1!4b1?entry=ttu")
            startActivity(openUrl)
        }

        val vedio = findViewById<Button>(R.id.reports)
        vedio.setOnClickListener(){
            val intent= Intent(this, Vedios::class.java)
            startActivity(intent)
        }

        val about = findViewById<Button>(R.id.about_us)
        about.setOnClickListener(){
            val intent= Intent(this, About_us::class.java)
            startActivity(intent)
        }

    }
}