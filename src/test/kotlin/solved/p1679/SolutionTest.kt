package solved.p1679

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test sorting solution`() = listOf(
        Pair(listOf(1, 2, 3, 4), 5) to 2,
        Pair(listOf(3, 1, 3, 4, 3), 6) to 1
    ).map { (input, expected) ->
        dynamicTest("There should be $expected number of ways to get ${input.second} as a sum of 2 elements from ${input.first}") {
            assertEquals(expected, Solution.SortingApproach().maxOperations(input.first.toIntArray(), input.second))
        }
    }

    @TestFactory
    fun `test hash map solution`() = listOf(
        Pair(listOf(1, 2, 3, 4), 5) to 2,
        Pair(listOf(3, 1, 3, 4, 3), 6) to 1
    ).map { (input, expected) ->
        dynamicTest("There should be $expected number of ways to get ${input.second} as a sum of 2 elements from ${input.first}") {
            assertEquals(expected, Solution.HashMapApproach().maxOperations(input.first.toIntArray(), input.second))
        }
    }
}