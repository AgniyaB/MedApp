package ru.itmo.medicalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import ru.itmo.medicalapp.patients.Patient
import ru.itmo.medicalapp.patients.PatientsStorage

class AddPatients : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_patients)
        val name = findViewById<EditText>(R.id.name)
        val okButton = findViewById<View>(R.id.ok_button)
        okButton.setOnClickListener {
            PatientsStorage.addPatient(0, Patient(name.text.toString()))
            finish()
        }
    }
}
