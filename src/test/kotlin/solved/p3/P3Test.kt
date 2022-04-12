package solved.p3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class P3Test {
    @TestFactory
    fun `test solution`() = listOf(
        "au" to 2,
        "abcabcbb" to 3,
        "bbbbb" to 1,
        "pwwkew" to 3,
        "abcbcade" to 5
    ).map { (input, output) ->
        dynamicTest("The length of longest substring without repeating characters of $input is $output") {
            val actual = Solution().lengthOfLongestSubstring(input)
            assertEquals(output, actual)
        }
    }
}