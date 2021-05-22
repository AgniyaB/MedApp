package ru.itmo.medicalapp.Models

class User {
    var email: String


    private fun setDataFromString(value: String) {

    }

    var pass: String = ""
    var name: String = ""
    var position: String = ""
    var department: String = ""

    constructor(email: String, pass: String, name: String, position: String, department: String) {
        this.email = email
        this.pass = pass
        this.name = name
        this.position = position
        this.department = department
    }


}