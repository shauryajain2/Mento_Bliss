package com.example.geekyhub.mento_bliss

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class mentalHealthResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mental_health_result)
        supportActionBar?.hide()

        val userScoreTextView = findViewById<TextView>(R.id.userScoreTextView)

        // Retrieve data from the intent
        val totalScore = intent.getIntExtra("TOTAL_SCORE", 0)
        val percentage = intent.getIntExtra("PERCENTAGE", 0)

        // Set the text for the TextViews

        val vedios = findViewById<Button>(R.id.vedio_modules)
        vedios.setOnClickListener(){
            val intent = Intent(this,Vedios::class.java)
            startActivity(intent)
        }

        val specialist = findViewById<Button>(R.id.visit_specialist)
        specialist.setOnClickListener(){
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://www.google.com/maps/search/psychiatrist+near+me/@28.6825986,77.2657815,11z/data=!3m1!4b1?entry=ttu")
            startActivity(openUrl)
        }
    }
}