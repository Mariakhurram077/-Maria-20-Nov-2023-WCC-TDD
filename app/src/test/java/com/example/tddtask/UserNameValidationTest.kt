package com.example.tddtask

import com.example.tddtask.validations.UserNameValidations
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

// tells jvm to test the case with parameters
@RunWith(value = Parameterized::class)
class UserNameValidationTest(
    private val inputUserName: String,
    private val expectedResult: Boolean
) {
    @Test
    fun testUserName() {

        //Arrange
        val userNameValidations = UserNameValidations()

        //Act
        val result = userNameValidations.validateUserName(inputUserName)

        //Assert
        assertEquals(expectedResult, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}:{0} is valid user name - {1}")

        //user name contains minimum 5 chars
        //user name contains maximum 14 chars
        //user name contains only alphanumeric characters
        //user name must not contains any special char
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("12346", false), //false as contains only digits
                arrayOf("maria@123", false), //false as contains special character
                arrayOf("Maria12345", true), //true as fulfill all above requirements
                arrayOf("maria0000", true), //true as fulfill all above requirements
                arrayOf("mksh", false), //false as length is less than 5 and contains no digit
                arrayOf("mk000000000000000000000000", false), //false as length is greater than 14
                arrayOf("Maria12345678", true), //true as fulfill all above requirements
                arrayOf("Maria_12345678", false) //false as contains special character

            )
        }
    }
}