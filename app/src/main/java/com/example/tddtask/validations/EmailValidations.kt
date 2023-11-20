package com.example.tddtask.validations

class EmailValidations {
    fun validateEmail(email:String):Boolean{

        // Regular expression pattern for email validation
        val emailPattern = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")

        // Validate the email using the pattern
        return email.matches(emailPattern)
    }
}