package ru.itmo.medicalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val btnEnter: Button = findViewById(R.id.btn_go)
        btnEnter.setOnClickListener {
            openLogIn()
        }
        val btnReg: Button = findViewById(R.id.btn_reg)
        btnReg.setOnClickListener {
            openSignUp()
        }
    }

    private fun openLogIn() {
        val intent = Intent(this, LogIn::class.java)
        startActivity(intent)
    }

    private fun openSignUp() {
        val intent = Intent(this, SignUp::class.java)
        startActivity(intent)
    }
}
