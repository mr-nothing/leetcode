package solved.p581

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test sorting solution`() = listOf(
        listOf(2, 6, 4, 8, 10, 9, 15) to 5,
        listOf(1, 2, 3, 4) to 0,
        listOf(1) to 0,
        listOf(1, 3, 2, 2, 2) to 4
    ).map { (input, expected) ->
        dynamicTest("To make $input sorted it should be enough to sort $expected elements") {
            assertEquals(expected, Solution.SortingApproach().findUnsortedSubarray(input.toIntArray()))
        }
    }

    @TestFactory
    fun `test two pointer solution`() = listOf(
        listOf(2, 6, 4, 8, 10, 9, 15) to 5,
        listOf(1, 2, 3, 4) to 0,
        listOf(1) to 0,
        listOf(1, 3, 2, 2, 2) to 4
    ).map { (input, expected) ->
        dynamicTest("To make $input sorted it should be enough to sort $expected elements") {
            assertEquals(expected, Solution.TwoPointerApproach().findUnsortedSubarray(input.toIntArray()))
        }
    }
}