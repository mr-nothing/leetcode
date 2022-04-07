package p1046

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test priority queue solution`() = listOf(
        arrayOf(2, 7, 4, 1, 8, 1) to 1,
        arrayOf(1) to 1
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The weight of the stone left after the game among $inputData is $expected") {
            Assertions.assertEquals(expected, PriorityQueueSolution().lastStoneWeight(inputData.toIntArray()))
        }
    }

    @TestFactory
    fun `test bucket sort solution`() = listOf(
        arrayOf(2, 7, 4, 1, 8, 1) to 1,
        arrayOf(1) to 1
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The weight of the stone left after the game among $inputData is $expected") {
            Assertions.assertEquals(expected, BucketSortSolution().lastStoneWeight(inputData.toIntArray()))
        }
    }
}