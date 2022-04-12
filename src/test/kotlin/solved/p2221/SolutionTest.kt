package solved.p2221

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        arrayOf(1,2,3,4,5) to 8,
        arrayOf(5) to 5
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The triangle sum of [${inputData.joinToString()}] sequence is $expected") {
            Assertions.assertEquals(expected, Solution().triangularSum(inputData.toIntArray()))
        }
    }
}