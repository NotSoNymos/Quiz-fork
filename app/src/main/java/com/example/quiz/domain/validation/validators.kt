package com.example.quiz.domain.validation

fun isValidEmail(email: String):Boolean {
    val regex = Regex("^[a-z0-9]+@[a-z0-9]+\\.ru$")
    return regex.matches(email)
}
fun isStrongPassword(password: String): Boolean {
    val regex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.* )(?=.*[^a-zA-Z0-9]).{8,}$")
    return regex.matches(password)
}