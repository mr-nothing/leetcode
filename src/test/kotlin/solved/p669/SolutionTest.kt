package solved.p669

import common.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        InputData(arrayOf(1, 0, 2), 1, 2) to arrayOf(1, null, 2),
        InputData(arrayOf(3, 0, 4, null, 2, null, null, 1), 1, 3) to arrayOf(3, 2, null, 1)
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("Tree trimmed ${inputData.values.joinToString()} in accordance with boundaries [${inputData.low}, ${inputData.high}] should be ${expected.joinToString()}") {
            Assertions.assertEquals(
                Solution().trimBST(TreeNode.from(inputData.values.toList()), inputData.low, inputData.high),
                TreeNode.from(expected.toList())
            )
        }
    }

    data class InputData(val values: Array<Int?>, val low: Int, val high: Int)
}