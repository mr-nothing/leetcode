package solved.p950

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        listOf(17, 13, 11, 2, 3, 5, 7) to listOf(2, 13, 3, 11, 5, 17, 7),
        listOf(1, 1000) to listOf(1, 1000)
    ).map { (input, expected) ->
        dynamicTest("The deck $input should be in order of $expected to reveal cards in increasing order") {
            assertEquals(expected, Solution().deckRevealedIncreasing(input.toIntArray()).toList())
        }
    }
}