package solved.p17

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        "23" to listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
        "" to listOf(),
        "2" to listOf("a", "b", "c"),
    ).map { (input, expected) ->
        dynamicTest("Phone number $input should be represented by $expected letter combinations") {
            assertEquals(expected, Solution().letterCombinations(input))
        }
    }
}