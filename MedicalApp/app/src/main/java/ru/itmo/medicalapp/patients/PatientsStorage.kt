package ru.itmo.medicalapp.patients

object PatientsStorage {
    val DEFAULT_PATIENTS_LIST =
        arrayListOf(Patient("John"), Patient("Mary"), Patient("Kirill"))
    private val patients: HashMap<Int, ArrayList<Patient>> =
        hashMapOf(Pair(0, DEFAULT_PATIENTS_LIST))

    fun addPatient(id: Int, patient: Patient) {
        patients[id]?.add(patient)
    }

    fun getPatients(id: Int): List<Patient> {
        return patients[id] ?: emptyList()
    }
}
