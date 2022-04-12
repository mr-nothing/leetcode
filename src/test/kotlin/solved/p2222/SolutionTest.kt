package solved.p2222

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        "001101" to 6L,
        "11100" to 0L
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The number of ways to choose restaurants and offices among $inputData is $expected") {
            Assertions.assertEquals(expected, Solution().numberOfWays(inputData))
        }
    }
}