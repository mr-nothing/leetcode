package solved.p173

import common.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair(
            listOf("BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"),
            listOf(
                listOf(7, 3, 15, null, null, 9, 20),
                listOf(),
                listOf(),
                listOf(),
                listOf(),
                listOf(),
                listOf(),
                listOf(),
                listOf(),
                listOf()
            )
        ) to listOf(null, 3, 7, true, 9, true, 15, true, 20, false)
    ).map { (input, expected) ->
        val actions = input.first
        val values = input.second
        DynamicTest.dynamicTest("The actions $actions with values $values of BST iterator should result to $expected") {
            val iterator = Solution.BSTIterator(TreeNode.from(values[0].toList())!!)
            val result = mutableListOf<Any?>()
            result.add(null)

            for (i in 1..actions.lastIndex) {
                when (actions[i]) {
                    "next" -> {
                        result.add(iterator.next())
                    }
                    "hasNext" -> {
                        result.add(iterator.hasNext())
                    }
                }
            }

            Assertions.assertEquals(expected, result)
        }
    }
}