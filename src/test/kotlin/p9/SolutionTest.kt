package p9

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        121 to true,
        1443223431 to false,
        1 to true,
        0 to true,
        -1923 to false,
        -111 to false
    ).map { (inputData, expected) ->
        val not = if (!expected) { "not" } else { "" }
        DynamicTest.dynamicTest("The integer $inputData should $not be treated as palindrome") {
            Assertions.assertEquals(expected, Solution().isPalindrome(inputData));
        }
    }


    @TestFactory
    fun `test solution not involving string conversion`() = listOf(
        10 to false,
        11 to true,
        777777777 to true,
        121 to true,
        1443223431 to false,
        1 to true,
        0 to true,
        -1923 to false,
        -111 to false
    ).map { (inputData, expected) ->
        val not = if (!expected) { "not" } else { "" }
        DynamicTest.dynamicTest("The integer $inputData should $not be treated as palindrome (no string conversion involved)") {
            Assertions.assertEquals(expected, Solution().isPalindrome2(inputData));
        }
    }
}