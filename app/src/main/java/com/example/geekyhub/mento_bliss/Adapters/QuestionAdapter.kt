

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.geekyhub.mento_bliss.Models.Question
import com.example.geekyhub.mento_bliss.R

class QuestionAdapter(val context: Context, private val questionsList: List<Question>) :
    RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.question_item, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questionsList[position]
        holder.bind(question)
    }

    override fun getItemCount(): Int = questionsList.size

    inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val questionDescription: TextView = itemView.findViewById(R.id.questionDescription)
        private val radioGroup: RadioGroup = itemView.findViewById(R.id.radioGroup)
        private val radioButton1: RadioButton = itemView.findViewById(R.id.radio_option1)
        private val radioButton2: RadioButton = itemView.findViewById(R.id.radio_option2)
        private val radioButton3: RadioButton = itemView.findViewById(R.id.radio_option3)
        private val radioButton4: RadioButton = itemView.findViewById(R.id.radio_option4)

        fun bind(question: Question) {
            questionDescription.text = question.description

            // Set the options text dynamically
            radioButton1.text = question.getOption(1)
            radioButton2.text = question.getOption(2)
            radioButton3.text = question.getOption(3)
            radioButton4.text = question.getOption(4)

            // Set radio button listeners
            radioButton1.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    question.selectedAnswer = "Never"
                }
            }
            radioButton2.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    question.selectedAnswer = "Sometimes"
                }
            }
            radioButton3.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    question.selectedAnswer = "Fairly Often"
                }
            }
            radioButton4.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    question.selectedAnswer = "Very Often"
                }
            }

            // Set a listener to update the user's answer when a radio button is checked
            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                val selectedIndex = listOf(
                    radioButton1.id, radioButton2.id, radioButton3.id, radioButton4.id
                ).indexOf(checkedId)
                if (selectedIndex != -1) {
                    question.setUserAnswer(selectedIndex + 1, question.getOption(selectedIndex + 1))
                }
            }
        }
    }
}
