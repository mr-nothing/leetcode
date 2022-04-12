package p5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class P5Test {

    @TestFactory
    fun `test solution`() = listOf(
        "" to "",
        "babad" to "bab",
        "cbbd" to "bb",
        "adbybda" to "adbybda",
        "asbbbsaaaasbbb" to "bbbsaaaasbbb"
    ).map { (inputData, expected) ->
        dynamicTest("The longest palindrome inside the [$inputData] should be [$expected]") {
            val actual = Solution().longestPalindrome(inputData)
            assertEquals(expected, actual)
        }
    }
}