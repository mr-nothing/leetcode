package solved.p680

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        "aba" to true,
        "abca" to true,
        "abc" to false,
        "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga" to true,
        "acxcybycxcxa" to true
    ).map { (input, expected) ->
        val not = if (expected) "" else "NOT"
        dynamicTest("$input should $not be palindrome after deleting at most one character") {
            assertEquals(expected, Solution().validPalindrome(input))
        }
    }
}