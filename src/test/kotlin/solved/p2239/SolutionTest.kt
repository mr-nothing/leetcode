package solved.p2239

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    private val data = listOf(
        listOf(2, 5, 7) to 2,
        listOf(-6, -5, -4, -3) to -3,
        listOf(-4, -2, 1, 4, 8) to 1,
        listOf(2, -1, 1) to 1,
        listOf(-6, -10, 1, 0, 38, 2, -1) to 0
    )

    @TestFactory
    fun `test binary search solution`() = data.map { (input, expected) ->
        DynamicTest.dynamicTest("The closest number to zero in $input should be $expected") {
            Assertions.assertEquals(expected, SortAndBinarySearch.Solution().findClosestNumber(input.toIntArray()))
        }
    }

    @TestFactory
    fun `test brute force solution`() = data.map { (input, expected) ->
        DynamicTest.dynamicTest("The closest number to zero in $input should be $expected") {
            Assertions.assertEquals(expected, BruteForce.Solution().findClosestNumber(input.toIntArray()))
        }
    }
}