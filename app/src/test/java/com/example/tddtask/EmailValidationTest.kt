package com.example.tddtask

import com.example.tddtask.validations.EmailValidations
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

// tells jvm to test the case with parameters
@RunWith(value = Parameterized::class)
class EmailValidationTest(private val inputEmail: String, private val expectedResult: Boolean) {

    @Test
    fun testEmail() {

        //Arrange
        val emailValidations = EmailValidations()

        //Act
        val result = emailValidations.validateEmail(inputEmail)

        //Assert
        assertEquals(expectedResult, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}:{0} is valid email - {1}")

        //passing different values for test as array
        //email pattern must be matching "abcde@anymail.anyword
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("mk123@g,gmail.com", false), //invalid email returns false
                arrayOf("123fkgmail@.com", false),  //invalid email returns false
                arrayOf("mariak12345@gmail.com", true), //valid email returns true
                arrayOf("mariak123@outlook.com", true), //valid email returns true
                arrayOf("mariak123gmail.com", false), //invalid email returns false
                arrayOf("mariak12345@outlookcom", false), //invalid email returns false
                arrayOf("mariak1234@microsoft.pk", true), //valid email return true
                arrayOf("mariak@gmail.com",true) //valid email return true
            )
        }
    }

}