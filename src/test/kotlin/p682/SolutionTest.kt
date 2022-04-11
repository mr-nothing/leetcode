package p682

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        arrayOf("5","2","C","D","+") to 30,
        arrayOf("5","-2","4","C","D","9","+","+") to 27
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The result of applying [${inputData.joinToString()}] operations should be $expected") {
            Assertions.assertEquals(expected, Solution().calPoints(inputData))
        }
    }
}