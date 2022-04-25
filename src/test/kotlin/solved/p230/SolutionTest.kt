package solved.p230

import common.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair(listOf(3, 1, 4, null, 2), 1) to 1,
        Pair(listOf(5, 3, 6, 2, 4, null, null, 1), 3) to 3
    ).map { (input, expected) ->
        val elements = input.first
        val k = input.second
        DynamicTest.dynamicTest("The k smallest in the tree $elements with k = $k should be $expected") {
            Assertions.assertEquals(
                expected,
                Solution().kthSmallest(TreeNode.from(elements)!!, k)
            )
        }
    }
}