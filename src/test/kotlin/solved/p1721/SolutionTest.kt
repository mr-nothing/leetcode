package solved.p1721

import common.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        InputData(listOf(1,2,3,4,5), 2) to listOf(1,4,3,2,5),
        InputData(listOf(7,9,6,6,7,8,3,0,9,5), 5) to listOf(7,9,6,6,8,7,3,0,9,5),
        InputData(listOf(4), 1) to listOf(4),
        InputData(listOf(1,2), 1) to listOf(2,1)
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The swapped version of ${inputData.values.joinToString()} with k = ${inputData.k} should be ${expected.joinToString()}") {
            val expectedList = ListNode.from(expected)
            val actualList = Solution().swapNodes(ListNode.from(inputData.values)!!, inputData.k)
            Assertions.assertEquals(expectedList, actualList)
        }
    }

    data class InputData(val values: List<Int>, val k: Int)
}