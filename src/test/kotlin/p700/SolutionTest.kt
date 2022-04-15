package p700

import common.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        InputData(arrayOf(4, 2, 7, 1, 3), 2) to arrayOf(2, 1, 3),
        InputData(arrayOf(4, 2, 7, 1, 3), 5) to arrayOf(),
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The node with root ${inputData.searchValue} of tree [${inputData.tree.joinToString()}] is [${expected.joinToString()}]") {
            Assertions.assertEquals(
                Solution().searchBST(TreeNode.from(inputData.tree.toList()), inputData.searchValue),
                TreeNode.from(expected.toList())
            )
        }
    }

    data class InputData(val tree: Array<Int>, val searchValue: Int)
}