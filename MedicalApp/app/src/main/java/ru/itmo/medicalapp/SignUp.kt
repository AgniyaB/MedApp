package ru.itmo.medicalapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import com.google.android.material.snackbar.Snackbar

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btnReg: Button = findViewById(R.id.button_reg)
        btnReg.setOnClickListener {
            addUser()
        }
    }

    @SuppressLint("WrongViewCast")
    private fun addUser() {
        val email: EditText = findViewById(R.id.emailReg)
        val pass: EditText = findViewById(R.id.passReg)
        val name: EditText = findViewById(R.id.name)
        val position: EditText = findViewById(R.id.position)
        val department: EditText = findViewById(R.id.department)
        val reg: ScrollView = findViewById(R.id.reg_element)

        if (TextUtils.isEmpty(email.text.toString())) {
            Snackbar.make(reg, "Введите вашу почту", Snackbar.LENGTH_SHORT).show()
            return
        }

        if (pass.text.toString().length < 5) {
            Snackbar.make(
                reg,
                "Ваш пароль должен содержать не менее 5 символов",
                Snackbar.LENGTH_SHORT
            ).show()
            return
        }

        if (TextUtils.isEmpty(name.text.toString())) {
            Snackbar.make(reg, "Введите ваше имя", Snackbar.LENGTH_SHORT).show()
            return
        }

        if (TextUtils.isEmpty(position.text.toString())) {
            Snackbar.make(reg, "Введите вашу должность", Snackbar.LENGTH_SHORT).show()
            return
        }

        if (TextUtils.isEmpty(department.text.toString())) {
            Snackbar.make(reg, "Введите ваше отделение", Snackbar.LENGTH_SHORT).show()
            return
        }
    }
}
