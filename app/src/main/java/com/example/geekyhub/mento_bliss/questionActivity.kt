package com.example.geekyhub.mento_bliss

import QuestionAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geekyhub.mento_bliss.Models.Question

class questionActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var questionAdapter: QuestionAdapter
    private val questionsList = mutableListOf<Question>()
    private var totalScore = 0

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        recyclerView = findViewById(R.id.questionlist)

        val calculateMentalHealthBtn = findViewById<Button>(R.id.CalculateMentalHealthbtn)
        calculateMentalHealthBtn.setOnClickListener {
            calculateScoreAndPercentage()
        }

        // Adding sample questions
        // ... (your existing questions)
        questionsList.add(
            Question(
                "I found myself getting upset by quite trivial things ",
                "Never",
                "Sometimes",
                "Fairly Often",
                " Very Often",
                "Never",
                "Never",
                "Sometimes",
                "Sometimes",
                "Fairly Often",
                "Fairly Often",
                "Very Often",
                "Very Often"
            )
        )

        questionsList.add(
            Question(
                "I just couldn't seem to get going ",
                "Never",
                "Sometimes",
                "Fairly Often",
                " Very Often",
                "Never",
                "Never",
                "Sometimes",
                "Sometimes",
                "Fairly Often",
                "Fairly Often",
                "Very Often",
                "Very Often"
            )
        )
        questionsList.add(
            Question(
                "I tended to over-react to situations ",
                "Never",
                "Sometimes",
                "Fairly Often",
                " Very Often",
                "Never",
                "Never",
                "Sometimes",
                "Sometimes",
                "Fairly Often",
                "Fairly Often",
                "Very Often",
                "Very Often"
            )
        )
        questionsList.add(
            Question(
                "I found difficult to relax ",
                "Never",
                "Sometimes",
                "Fairly Often",
                " Very Often",
                "Never",
                "Never",
                "Sometimes",
                "Sometimes",
                "Fairly Often",
                "Fairly Often",
                "Very Often",
                "Very Often"
            )
        )
        questionsList.add(
            Question(
                "I felt that I was using a lot of nervous energy ",
                "Never",
                "Sometimes",
                "Fairly Often",
                " Very Often",
                "Never",
                "Never",
                "Sometimes",
                "Sometimes",
                "Fairly Often",
                "Fairly Often",
                "Very Often",
                "Very Often"
            )
        )
        questionsList.add(
            Question(
                "I felt sad and depressed ",
                "Never",
                "Sometimes",
                "Fairly Often",
                " Very Often",
                "Never",
                "Never",
                "Sometimes",
                "Sometimes",
                "Fairly Often",
                "Fairly Often",
                "Very Often",
                "Very Often"
            )
        )
        questionsList.add(
            Question(
                "I felt that I had nothing to look forward to  ",
                "Never",
                "Sometimes",
                "Fairly Often",
                " Very Often",
                "Never",
                "Never",
                "Sometimes",
                "Sometimes",
                "Fairly Often",
                "Fairly Often",
                "Very Often",
                "Very Often"
            )
        )
        questionsList.add(
            Question(
                "I felt that life wasn't worthwhile",
                "Never",
                "Sometimes",
                "Fairly Often",
                " Very Often",
                "Never",
                "Never",
                "Sometimes",
                "Sometimes",
                "Fairly Often",
                "Fairly Often",
                "Very Often",
                "Very Often"
            )
        )

        // Create an instance of the adapter and set it to the RecyclerView
        questionAdapter = QuestionAdapter(this, questionsList)
        recyclerView.adapter = questionAdapter

        // Set a layout manager (e.g., LinearLayoutManager)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun calculateScoreAndPercentage() {
        totalScore = 0 // Reset total score before calculating
        for (question in questionsList) {
            totalScore += calculateQuestionScore(question)
        }

        // Calculate the percentage based on the total score
        val maxPossibleScore = questionsList.size * 3 // Assuming each question has 4 options, so max score per question is 3
        val percentage = (totalScore.toDouble() / maxPossibleScore) * 100

        // Now, you have the total score and percentage, and you can use them as needed.
        // For example, you can pass them to the next activity via Intent.
        val intent = Intent(this, mentalHealthResultActivity::class.java)
        intent.putExtra("TOTAL_SCORE", totalScore)
        intent.putExtra("PERCENTAGE", percentage.toInt()) // Convert to int if you want to pass it as an integer
        startActivity(intent)
    }

    private fun calculateQuestionScore(question: Question): Int {
        var score = 0

        // Compare user answers with correct answers and assign scores accordingly
        score += getOptionScore(question.useranswer1, question.answer1)
        score += getOptionScore(question.useranswer2, question.answer2)
        score += getOptionScore(question.useranswer3, question.answer3)
        score += getOptionScore(question.useranswer4, question.answer4)

        return score
    }

    private fun getOptionScore(userAnswer: String, correctAnswer: String): Int {
        // Define the scoring logic for each option
        return when (userAnswer) {
            correctAnswer -> 0 // Correct answer
            "Never" -> 0
            "Sometimes" -> 1
            "Fairly Often" -> 2
            "Very Often" -> 3
            else -> 0 // Default to 0 if the user's answer is not recognized
        }
    }

    // If you need to reset user answers (call this function when needed)
    private fun resetUserAnswers() {
        for (question in questionsList) {
            question.useranswer1 = ""
            question.useranswer2 = ""
            question.useranswer3 = ""
            question.useranswer4 = ""
        }
    }
}
