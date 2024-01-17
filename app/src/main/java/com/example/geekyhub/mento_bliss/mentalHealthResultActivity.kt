package com.example.geekyhub.mento_bliss

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class mentalHealthResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mental_health_result)

        val userScoreTextView = findViewById<TextView>(R.id.userScoreTextView)
        val percentageTextView = findViewById<TextView>(R.id.percentageTextView)

        // Retrieve data from the intent
        val totalScore = intent.getIntExtra("TOTAL_SCORE", 0)
        val percentage = intent.getIntExtra("PERCENTAGE", 0)

        // Set the text for the TextViews
        userScoreTextView.text = "Your Score: $totalScore"
        percentageTextView.text = "Percentage: $percentage%"
    }
}