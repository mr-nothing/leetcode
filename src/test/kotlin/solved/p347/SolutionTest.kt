package solved.p347

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        InputData(arrayOf(1,1,1,2,2,3), 2) to arrayOf(1, 2),
        InputData(arrayOf(1), 1) to arrayOf(1)
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("${inputData.k} most frequent numbers in ${inputData.nums.joinToString()} are ${expected.joinToString()}") {
            val expectedArray = expected.toIntArray()
            val actualArray = Solution().topKFrequent(inputData.nums.toIntArray(), inputData.k)
            Assertions.assertEquals(expectedArray.sort(), actualArray.sort())
        }
    }

    data class InputData(val nums: Array<Int>, val k: Int)
}