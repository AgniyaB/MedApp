package ru.itmo.medicalapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextClock
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.rengwuxian.materialedittext.MaterialEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import ru.itmo.medicalapp.Models.User

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btnReg: Button = findViewById(R.id.btn_reg)
        btnReg.setOnClickListener {
            addUser()
        }
    }

    @SuppressLint("WrongViewCast")
    private fun addUser() {
        val email: MaterialEditText = findViewById(R.id.emailReg)
        val pass: MaterialEditText = findViewById(R.id.passReg)
        val name: MaterialEditText = findViewById(R.id.name)
        val position: MaterialEditText = findViewById(R.id.position)
        val department: MaterialEditText = findViewById(R.id.department)
        val reg: ConstraintLayout = findViewById(R.id.reg_element)

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
        val auth: FirebaseAuth = FirebaseAuth.getInstance()

        val db: FirebaseDatabase = FirebaseDatabase.getInstance()

        val users: DatabaseReference = db.getReference("Users")

        //Регистрация
        /*auth.createUserWithEmailAndPassword(email.text.toString(), pass.text.toString())
            .addOnSuccessListener(OnSuccessListener<AuthResult>(){
                fun onSuccess(authResult: AuthResult) {
                    val user: User
            })
    }*/
    }
}
