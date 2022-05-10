package solved.p216

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair(3, 7) to listOf(listOf(1, 2, 4)),
        Pair(3, 9) to listOf(listOf(1, 2, 6), listOf(1, 3, 5), listOf(2, 3, 4)),
        Pair(4, 1) to listOf()
    ).map { (input, expected) ->
        dynamicTest("$expected should be the only combinations to get ${input.second} as a sum of ${input.first} number of digits") {
            assertEquals(expected, Solution().combinationSum3(input.first, input.second))
        }
    }
}