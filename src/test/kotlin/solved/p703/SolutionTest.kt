package solved.p703

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test bucket sort solution`() = listOf(
        InputData(3, arrayOf(4, 5, 8, 2).toIntArray(), arrayOf(3, 5, 10, 9, 4).toIntArray()) to arrayOf(4, 5, 5, 8, 8),
        InputData(1,arrayOf<Int>().toIntArray(), arrayOf(-3,-2,-4,0,4).toIntArray()) to arrayOf(-3, -2, -2, 0, 4)
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The kth max element should be...") {
            val kthLargest = BucketSortSolution.KthLargest(inputData.k, inputData.init)

            if (inputData.additions.size != expected.size) {
                throw IllegalStateException("Number of elements to add and elements of expected kth max values should be the same.")
            }

            val additions = inputData.additions
            for (i in 0..expected.lastIndex) {
                val valueToAdd = additions[i]
                val expectedKthLargest = expected[i]
                Assertions.assertEquals(kthLargest.add(valueToAdd), expectedKthLargest)
            }
        }
    }

    @TestFactory
    fun `test heap sort solution`() = listOf(
        InputData(3, arrayOf(4, 5, 8, 2).toIntArray(), arrayOf(3, 5, 10, 9, 4).toIntArray()) to arrayOf(4, 5, 5, 8, 8),
        InputData(1,arrayOf<Int>().toIntArray(), arrayOf(-3,-2,-4,0,4).toIntArray()) to arrayOf(-3, -2, -2, 0, 4)
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The kth max element should be...") {
            val kthLargest = HeapSolution.KthLargest(inputData.k, inputData.init)

            if (inputData.additions.size != expected.size) {
                throw IllegalStateException("Number of elements to add and elements of expected kth max values should be the same.")
            }

            val additions = inputData.additions
            for (i in 0..expected.lastIndex) {
                val valueToAdd = additions[i]
                val expectedKthLargest = expected[i]
                Assertions.assertEquals(kthLargest.add(valueToAdd), expectedKthLargest)
            }
        }
    }

    data class InputData(val k: Int, val init: IntArray, val additions: IntArray)
}