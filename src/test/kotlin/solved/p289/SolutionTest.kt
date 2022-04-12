package solved.p289

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test additional array solution`() = listOf(
        arrayOf(intArrayOf(0,1,0), intArrayOf(0,0,1), intArrayOf(1,1,1), intArrayOf(0,0,0)) to arrayOf(intArrayOf(0,0,0), intArrayOf(1,0,1), intArrayOf(0,1,1), intArrayOf(0,1,0)),
        arrayOf(intArrayOf(1,1), intArrayOf(1,0)) to arrayOf(intArrayOf(1,1), intArrayOf(1,1))
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The result of game of life on ${inputData.joinToString { it.contentToString() }} should be ${expected.joinToString { it.contentToString() }}") {
            AdditionalArraySolution.Solution().gameOfLife(inputData)
            Assertions.assertArrayEquals(inputData, expected)
        }
    }

    @TestFactory
    fun `test in place solution`() = listOf(
        arrayOf(intArrayOf(0,1,0), intArrayOf(0,0,1), intArrayOf(1,1,1), intArrayOf(0,0,0)) to arrayOf(intArrayOf(0,0,0), intArrayOf(1,0,1), intArrayOf(0,1,1), intArrayOf(0,1,0)),
        arrayOf(intArrayOf(1,1), intArrayOf(1,0)) to arrayOf(intArrayOf(1,1), intArrayOf(1,1))
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The result of game of life on ${inputData.joinToString { it.contentToString() }} should be ${expected.joinToString { it.contentToString() }}") {
            InPlaceSolution.Solution().gameOfLife(inputData)
            Assertions.assertArrayEquals(inputData, expected)
        }
    }
}