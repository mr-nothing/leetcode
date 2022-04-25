package solved.p897

import common.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        listOf(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9) to listOf(
            1,
            null,
            2,
            null,
            3,
            null,
            4,
            null,
            5,
            null,
            6,
            null,
            7,
            null,
            8,
            null,
            9
        ),
        listOf(5, 1, 7) to listOf(1, null, 5, null, 7)
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Increasing order tree build from $input should be $expected") {
            Assertions.assertEquals(
                TreeNode.from(expected.toList()),
                Solution().increasingBST(TreeNode.from(input.toList()))
            )
        }
    }
}