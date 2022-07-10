package solved.p2300

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Triple(intArrayOf(5, 1, 3), intArrayOf(1, 2, 3, 4, 5), 7L) to intArrayOf(4, 0, 3),
        Triple(intArrayOf(3, 1, 2), intArrayOf(8, 5, 8), 16L) to intArrayOf(2, 0, 2)
    ).map { (input, expected) ->
        DynamicTest.dynamicTest(
            "The pairs of spells ${input.first.joinToString()} and " +
                    "${input.second.joinToString()} with success factor of at least" +
                    " ${input.third} should be ${expected.joinToString()}"
        ) {
            assertEquals(expected.toList(), Solution().successfulPairs(input.first, input.second, input.third).toList())
        }
    }
}