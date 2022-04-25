package solved.p538

import common.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        listOf(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8) to listOf(
            30,
            36,
            21,
            36,
            35,
            26,
            15,
            null,
            null,
            null,
            33,
            null,
            null,
            null,
            8
        ),
        listOf(0, null, 1) to listOf(1, null, 1)
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The greater tree built from ${inputData.joinToString()} should be ${expected.joinToString()}") {
            Assertions.assertEquals(
                TreeNode.from(expected.toList()),
                Solution().convertBST(TreeNode.from(inputData.toList()))
            )
        }
    }
}