package solved.p11

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        arrayOf(1,8,6,2,5,4,8,3,7) to 49,
        arrayOf(1, 1) to 1
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The most spacious water container in [${inputData.joinToString()}] between 2 heights is $expected") {
            Assertions.assertEquals(expected, Solution().maxArea(inputData.toIntArray()))
        }
    }
}