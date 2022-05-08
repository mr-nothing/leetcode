package p456

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        listOf(1, 2, 3, 4) to false,
        listOf(3, 1, 4, 2) to true,
        listOf(-1, 3, 2, 0) to true
    ).map { (input, expected) ->
        val not = if (expected) "" else "not"
        dynamicTest("132 subsequence should $not be found in $input") {
            assertEquals(expected, Solution().find132pattern(input.toIntArray()))
        }
    }
}