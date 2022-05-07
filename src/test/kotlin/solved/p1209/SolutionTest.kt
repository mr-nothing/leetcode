package solved.p1209

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair("abcd", 2) to "abcd",
        Pair("deeedbbcccbdaa", 3) to "aa",
        Pair("pbbcggttciiippooaais", 2) to "ps",
        Pair("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4) to "ybth"
    ).map { (input, expected) ->
        dynamicTest("String ${input.first} should be transformed to $expected after all ${input.second} adjacent duplicates are removed") {
            assertEquals(expected, Solution().removeDuplicates(input.first, input.second))
        }
    }
}