package com.example.tddtask

import com.example.tddtask.validations.PasswordValidations
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

// tells jvm to test the case with parameters
@RunWith(value = Parameterized::class)
class PasswordValidationTest(
    private val inputPassword: String,
    private val expectedResult: Boolean
) {
    @Test
    fun testPassword() {

        //Arrange
        val passwordValidations = PasswordValidations()

        //Act
        val result = passwordValidations.validatePassword(inputPassword)

        //Assert
        assertEquals(expectedResult, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}:{0} is valid password - {1}")

        //passing different values for test as array
        //password must contains at least one special character
        //minimum length must be 6
        //contains at least 1 digit
        //contains at least one Upper case alphabet

        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("12346", false), //false as only contains numerics an length is less than 6
                arrayOf("hello123", false), //false as contains no special character and no Upper case
                arrayOf("maria12345AJ@#", true), //true as it fulfill all above requirements
                arrayOf("Maria*123", true), //true as it fulfill all above requirements
                arrayOf("mksh", false), //false as contains no special character and no Upper case and no digit and length is also less than 6
                arrayOf("mk1234K", false), //false as contains no special character
                arrayOf("mARiakkk678#", true) //true as it fulfill all above requirements
            )
        }
    }
}