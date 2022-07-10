package solved.p152

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        intArrayOf(2, 3, -2, 4) to 6,
        intArrayOf(-2, 0, -1) to 0,
        intArrayOf(0, 2) to 2,
        intArrayOf(3, -1, 4) to 4,
        intArrayOf(-1, 9, 8, 7, 6, -2) to 6048
    ).map { (input, expected) ->
        dynamicTest("The maximal product of subsequent element of ${input.joinToString()} should be $expected") {
            assertEquals(expected, Solution().maxProduct(input))
        }
    }
}