package com.example.tddtask.validations

class UserNameValidations {

    //user name contains minimum 5 chars
    //user name contains maximum 14 chars
    //user name contains only alphanumeric characters
    //user name must not contains any special char
    fun validateUserName(username: String): Boolean {
        val minLength = 5 // Minimum length requirement for the username
        val maxLength = 14 // Maximum length requirement for the username

        // alphanumeric user name only
        val usernamePattern = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]*\$")
        return (username.length in minLength..maxLength) && username.matches(usernamePattern)
    }
}