package com.example.studychart

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener


class LoginScreen : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        auth = FirebaseAuth.getInstance()

        val loginbtn = findViewById<Button>(R.id.loginBtn)
        loginbtn.setOnClickListener {
            login()
        }
    }

    private fun login() {

        val email = findViewById<EditText>(R.id.email_ed).text.toString()
        val password = findViewById<EditText>(R.id.password_ed).text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, HomeScreen::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                    }
                })
        }

        if (email.isNotEmpty() && password.isNotEmpty()){
            val settings = getSharedPreferences(PREFS_NAME, 0)
            val editor = settings.edit()
            editor.putString("logged", "logged")
            editor.apply()
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
        }
    }



    companion object{
        const val PREFS_NAME =  "LoginPref"
    }

}