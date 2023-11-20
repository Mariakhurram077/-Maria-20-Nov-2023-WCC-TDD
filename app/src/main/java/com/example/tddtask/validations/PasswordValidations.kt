package com.example.tddtask.validations

class PasswordValidations {

    //validate password for,
    // it must contains at least one special character
    //minimum length must be 6
    //contains at least 1 digit
    //contains at least one Upper case alphabet

    fun validatePassword(password: String): Boolean {
        val minLength = 6
        val specialCharacters = setOf('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=')
        var containsSpecialChar = false
        var containsDigit = false
        var containsUpperCase = false

        if (password.length < minLength) return false

        for (char in password) {
            if (char in specialCharacters) {
                containsSpecialChar = true
            } else if (char.isDigit()) {
                containsDigit = true
            } else if (char.isUpperCase()) {
                containsUpperCase = true
            }
        }

        return containsSpecialChar && containsDigit && containsUpperCase
}}