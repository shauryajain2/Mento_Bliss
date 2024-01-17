package com.example.geekyhub.mento_bliss.Models

data class Question(
    var description: String = "",
    var option1: String = "",
    var option2: String = "",
    var option3: String = "",
    var option4: String = "",
    var useranswer1: String = "",
    var answer1: String = "",
    var useranswer2: String = "",
    var answer2: String = "",
    var useranswer3: String = "",
    var answer3: String = "",
    var useranswer4: String = "",
    var answer4: String = "",
    var scoreOption1: Int = 0,
    var scoreOption2: Int = 0,
    var scoreOption3: Int = 0,
    var scoreOption4: Int = 0,
    var selectedAnswer:String=""
) {
    fun getOption(index: Int): String {
        return when (index) {
            1 -> option1
            2 -> option2
            3 -> option3
            4 -> option4
            else -> ""
        }
    }

    fun getUserAnswer(index: Int): String {
        return when (index) {
            1 -> useranswer1
            2 -> useranswer2
            3 -> useranswer3
            4 -> useranswer4
            else -> ""
        }
    }

    fun setUserAnswer(index: Int, answer: String) {
        when (index) {
            1 -> useranswer1 = answer
            2 -> useranswer2 = answer
            3 -> useranswer3 = answer
            4 -> useranswer4 = answer
        }
    }
}
