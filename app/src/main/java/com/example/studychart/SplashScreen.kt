package com.example.studychart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.studychart.databinding.ActivitySplashscreenBinding

class SplashScreen :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        val settings = getSharedPreferences(PREFS_NAME, 0)
        val mybutton = findViewById<Button>(R.id.toLoginScreen)
        val signuptxt = findViewById<TextView>(R.id.signupTxt)


            if (settings.getString("logged", "").toString() == "logged"){
                startActivity(Intent(this , HomeScreen::class.java))
            }else{
            mybutton.setOnClickListener {
                startActivity(Intent(this, LoginScreen::class.java))
            }
            signuptxt.setOnClickListener {
                startActivity(Intent(this, SignupScreen::class.java))
            }
            }

//        val handler = Handler()
//        handler.postDelayed({
//            startActivity(Intent(this, HomeScreen::class.java))
//            finish()
//        }, 5000)

        fun loginscreen(){
            mybutton.setOnClickListener {
                startActivity(Intent(this, LoginScreen::class.java))
            }
        }
    }

    companion object {
        const val PREFS_NAME = "LoginPrefs"
    }
}