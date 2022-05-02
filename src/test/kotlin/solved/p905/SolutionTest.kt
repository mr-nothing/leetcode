package solved.p905

import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test additional linked list solution`() = listOf(
        listOf(3, 1, 2, 4),
        listOf(0)
    ).map { input ->
        dynamicTest("Array should be sorted by parity $input") {
            assertSortedByParity(Solution.AdditionalLinkedListApproach().sortArrayByParity(input.toIntArray()))
        }
    }

    @TestFactory
    fun `test in place swap solution`() = listOf(
        listOf(3, 1, 2, 4),
        listOf(0)
    ).map { input ->
        dynamicTest("Array should be sorted by parity $input") {
            assertSortedByParity(Solution.InPlaceSwapApproach().sortArrayByParity(input.toIntArray()))
        }
    }

    private fun assertSortedByParity(nums: IntArray) {
        var metOdd = false
        for (num in nums) {
            if (num % 2 == 0) {
                assert(!metOdd) { "Detected even number after odd number" }
            } else {
                metOdd = true
            }
        }
    }
}