package com.example.geekyhub.mento_bliss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.geekyhub.mento_bliss.Models.User
import com.example.geekyhub.mento_bliss.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.loginBtn.setOnClickListener(){
            if(binding.email.text.toString().equals("")or
                binding.password.text.toString().equals("")){
                Toast.makeText(this,"Please fil all the details", Toast.LENGTH_SHORT).show()
            }else{
               val user=User(binding.email.text.toString(),binding.password.text.toString())
                val auth = FirebaseAuth.getInstance()
                auth.signInWithEmailAndPassword(user.email.toString(), user.password.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent= Intent(this,HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this,it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        binding.createNewAccountBtn.setOnClickListener(){
            val intent= Intent(this,Sign_Up::class.java)
            startActivity(intent)
        }

    }
}