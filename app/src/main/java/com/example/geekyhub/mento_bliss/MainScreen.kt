package com.example.geekyhub.mento_bliss

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.geekyhub.mento_bliss.databinding.ActivityHomeBinding

class MainScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        supportActionBar?.hide()

        val test = findViewById<CardView>(R.id.conduct_test)
        test.setOnClickListener(){
            val intent= Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        val playlist = findViewById<CardView>(R.id.playlists)
        playlist.setOnClickListener(){
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://www.google.com/maps/search/psychiatrist+near+me/@28.6825986,77.2657815,11z/data=!3m1!4b1?entry=ttu")
            startActivity(openUrl)
        }

        val vedio = findViewById<CardView>(R.id.reports)
        vedio.setOnClickListener(){
            val intent= Intent(this, Vedios::class.java)
            startActivity(intent)
        }

        val about = findViewById<CardView>(R.id.about_us)
        about.setOnClickListener(){
            val intent= Intent(this, About_us::class.java)
            startActivity(intent)
        }

    }
}