package p99

import common.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        arrayOf(1, 3, null, null, 2) to arrayOf(3, 1, null, null, 2),
        arrayOf(3, 1, 4, null, null, 2) to arrayOf(2, 1, 4, null, null, 3)
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("Correct form of binary tree ${inputData.joinToString()} should be ${expected.joinToString()}") {
            val inputTree = TreeNode.from(inputData.toList())
            val expectedTree = TreeNode.from(expected.toList())

            Solution().recoverTree(inputTree!!)

            Assertions.assertEquals(inputTree, expectedTree)
        }
    }
}