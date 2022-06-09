package solved.p167

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair(listOf(2, 7, 11, 15), 9) to listOf(1, 2),
        Pair(listOf(2, 3, 4), 6) to listOf(1, 3),
        Pair(listOf(-1, 0), -1) to listOf(1, 2)
    ).map { (input, expected) ->
        dynamicTest("The numbers from array ${input.first.joinToString()} that sum up to ${input.second} should be ${expected.joinToString()}") {
            assertEquals(expected, Solution().twoSum(input.first.toIntArray(), input.second).toList())
        }
    }
}