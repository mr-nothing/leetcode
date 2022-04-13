package p59

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        3 to arrayOf(intArrayOf(1, 2, 3), intArrayOf(8, 9, 4), intArrayOf(7, 6, 5)),
        1 to arrayOf(intArrayOf(1))
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The result of $inputData matrix generation should be ${expected.joinToString { it.joinToString() }}") {
            Assertions.assertArrayEquals(expected, Solution().generateMatrix(inputData))
        }
    }
}