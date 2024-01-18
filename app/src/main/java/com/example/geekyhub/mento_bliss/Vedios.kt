package com.example.geekyhub.mento_bliss

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class Vedios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vedios)

        supportActionBar?.hide()

        val stress1 = findViewById<LinearLayout>(R.id.stress1)
        stress1.setOnClickListener(){
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://youtu.be/Nz9eAaXRzGg?si=d66MfMagD1mD_96j")
            startActivity(openUrl)
        }
        val stress2 = findViewById<LinearLayout>(R.id.stress2)
        stress2.setOnClickListener(){
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://youtu.be/Y_wcDzI05qE?si=FG41mLQkmdk-t5B2")
            startActivity(openUrl)
        }
        val stress3 = findViewById<LinearLayout>(R.id.stress3)
        stress3.setOnClickListener(){
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://youtu.be/jUlIraefu-c?si=98yF3E-xxvHTtQHs")
            startActivity(openUrl)
        }

        val depress1 = findViewById<LinearLayout>(R.id.depress1)
        depress1.setOnClickListener(){
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://youtu.be/sWfNosruPPw?si=_zLOqolL-YSSqKjW")
            startActivity(openUrl)
        }
        val depress2 = findViewById<LinearLayout>(R.id.depress2)
        depress2.setOnClickListener(){
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://www.youtube.com/watch?v=sWfNosruPPw")
            startActivity(openUrl)
        }
        val depress3 = findViewById<LinearLayout>(R.id.depress3)
        depress3.setOnClickListener(){
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://www.youtube.com/watch?v=d96akWDnx0w")
            startActivity(openUrl)
        }

        val anxiety1 = findViewById<LinearLayout>(R.id.anxiety1)
        anxiety1.setOnClickListener(){
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://youtu.be/MK0rESk_oW0?si=AobjiBFQn-NYlE5a")
            startActivity(openUrl)
        }
        val anxiety2 = findViewById<LinearLayout>(R.id.anxiety2)
        anxiety2.setOnClickListener(){
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://youtu.be/PxjxY9VilCs?si=RBfw2pkO0PG6dIGN")
            startActivity(openUrl)
        }
        val anxiety3 = findViewById<LinearLayout>(R.id.anxiety3)
        anxiety3.setOnClickListener(){
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://youtu.be/WWloIAQpMcQ?si=uVBb-9ZiHLTfhvEz")
            startActivity(openUrl)
        }
    }
}