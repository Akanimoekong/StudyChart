package com.example.studychart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.studychart.databinding.ActivitySignupScreenBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup_screen.*

class SignupScreen : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: SignupScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_screen)
        auth = FirebaseAuth.getInstance()

        val done = findViewById<TextView>(R.id.signupDone)

        done.setOnClickListener {
            signup()
        }

    }

    private fun signup () {
        val email = findViewById<EditText>(R.id.email_ed).text.toString()
        val password = findViewById<EditText>(R.id.password_ed).text.toString()
//        val email = binding.email_ed.text.toString()
//        val password = binding.password_ed.text.toString()
        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, LoginScreen::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Registration Failed", Toast.LENGTH_LONG).show()
                    }
                })
        }

    }


}