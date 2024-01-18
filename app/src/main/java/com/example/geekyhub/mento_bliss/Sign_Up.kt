package com.example.geekyhub.mento_bliss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.geekyhub.mento_bliss.Models.User
import com.example.geekyhub.mento_bliss.databinding.ActivitySignUpBinding
import com.example.geekyhub.mento_bliss.utils.USER_NODE
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Sign_Up : AppCompatActivity() {
 private val binding by lazy {
     ActivitySignUpBinding.inflate(layoutInflater)
 }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        var user= User()

        binding.account.setOnClickListener(){
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
     binding.signUpBtn.setOnClickListener(){
         val name = binding.name.text.toString()
         val email = binding.email.text.toString()
         val password = binding.password.text.toString()

         if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
             Toast.makeText(this, "Please enter all the information", Toast.LENGTH_SHORT)
                 .show()
         } else {
             // Create a Firebase authentication user
             FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                 .addOnCompleteListener { task ->
                     if (task.isSuccessful) {
                         val uid = FirebaseAuth.getInstance().currentUser?.uid
                         if (uid != null) {
                             user.name = name
                             user.email = email
                             user.password = password

                             // Store the user data in Firestore
                             FirebaseFirestore.getInstance().collection(USER_NODE).document(uid).set(user).addOnSuccessListener {
                                 Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
                                 val intent = Intent(this, MainScreen::class.java)
                                 startActivity(intent)
                             }.addOnFailureListener { e ->
                                 Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
                             }
                         }
                     } else {
                         Toast.makeText(this, task.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                     }
                 }
         }
     }



    }
}