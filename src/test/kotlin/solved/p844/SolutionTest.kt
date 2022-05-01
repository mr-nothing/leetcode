package solved.p844

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair("ab#c", "ad#c") to true,
        Pair("ab##", "c#d#") to true,
        Pair("a#c", "b") to false,
        Pair("a#b#########", "a#b#") to true
    ).map { (input, expected) ->
        val not = if (expected) "" else "NOT"
        dynamicTest("Backspaced strings ${input.first} and ${input.second} should $not be equal") {
            assertEquals(expected, Solution().backspaceCompare(input.first, input.second))
        }
    }
}