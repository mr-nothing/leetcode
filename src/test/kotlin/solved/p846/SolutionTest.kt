package solved.p846

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair(intArrayOf(1, 2, 3, 6, 2, 3, 4, 7, 8), 3) to true,
        Pair(intArrayOf(1, 2, 3, 4, 5), 4) to false
    ).map { (input, expected) ->
        val not = if (expected) "" else "not"
        dynamicTest("It should $not be possible to group cards ${input.first} into consecutive group of ${input.second}") {
            assertEquals(expected, Solution().isNStraightHand(input.first, input.second))
        }
    }
}