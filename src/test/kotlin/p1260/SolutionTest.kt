package p1260

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        InputData(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
            ), 1)
                to listOf(
            listOf(9, 1, 2),
            listOf(3, 4, 5),
            listOf(6, 7, 8)
        ),
        InputData(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
            ), 8)
                to listOf(
            listOf(2, 3, 4),
            listOf(5, 6, 7),
            listOf(8, 9, 1)
        ),
        InputData(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
            ), 6)
                to listOf(
            listOf(4, 5, 6),
            listOf(7, 8, 9),
            listOf(1, 2, 3)
        ),
        InputData(
            arrayOf(
                intArrayOf(1),
                intArrayOf(2),
                intArrayOf(3),
                intArrayOf(4),
                intArrayOf(7),
                intArrayOf(6),
                intArrayOf(5),
            ), 23)
                to listOf(
            listOf(6),
            listOf(5),
            listOf(1),
            listOf(2),
            listOf(3),
            listOf(4),
            listOf(7)
        ),
        InputData(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
            ), 9)
                to listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9)
        ),
        InputData(
            arrayOf(
                intArrayOf(3, 8, 1, 9),
                intArrayOf(19, 7, 2, 5),
                intArrayOf(4, 6, 11, 10),
                intArrayOf(12, 0, 21, 13)
            ), 4
        ) to listOf(
            listOf(12, 0, 21, 13),
            listOf(3, 8, 1, 9),
            listOf(19, 7, 2, 5),
            listOf(4, 6, 11, 10)
        ),


    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("${inputData.k} rotations on ${inputData.grid.joinToString { it.contentToString() }} should result to ${expected.joinToString { it.joinToString() }}") {
            Assertions.assertEquals(expected, Solution().shiftGrid(inputData.grid, inputData.k))
        }
    }

    data class InputData(val grid: Array<IntArray>, val k: Int)

}