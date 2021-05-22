package ru.itmo.medicalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter: Button = findViewById(R.id.btn_go)
        btnEnter.setOnClickListener{
            openLogIn()
        }
        val btnReg: Button = findViewById(R.id.btn_reg)
        btnReg.setOnClickListener{
            openSigUp()
        }
    }

    private fun openLogIn(){
        val intent = Intent(this, LogIn::class.java)
        startActivity(intent)

    }

    private fun openSigUp(){
        val intent = Intent(this, SignUp::class.java)
        startActivity(intent)
    }


}
