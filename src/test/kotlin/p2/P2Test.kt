package p2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class P2Test {
    @TestFactory
    fun `test problem 2`() = listOf(
        TestInput(listOf(2, 4, 3), listOf(5, 6, 4)) to TestOutput(listOf(7, 0, 8)),
        TestInput(listOf(0), listOf(0)) to TestOutput(listOf(0)),
        TestInput(listOf(9, 9, 9, 9, 9, 9, 9), listOf(9, 9, 9, 9)) to TestOutput(listOf(8, 9, 9, 9, 0, 0, 0, 1))
    ).map { (input, output) ->
        dynamicTest("${input.l1} plus ${input.l2} should be equal to ${output.l}") {
            val actual = Solution().addTwoNumbers(listToNode(input.l1), listToNode(input.l2))

            assertEquals(output.l, nodeToList(actual))
        }
    }

    private fun listToNode(digitsList: List<Int>): ListNode? {
        val digit = digitsList.firstOrNull()
        digit?.let {
            val currentNode = ListNode(digit)
            currentNode.next = listToNode(digitsList.subList(1, digitsList.size))
            return currentNode
        }
        return null
    }

    private fun nodeToList(node: ListNode): List<Int> {
        val result = mutableListOf<Int>()
        var currentNode = node
        while (true) {
            result.add(currentNode.`val`)
            currentNode.next?.let {
                currentNode = it
            } ?: break
        }
        return result
    }
}

data class TestInput(
    val l1: List<Int>,
    val l2: List<Int>
)

data class TestOutput(
    val l: List<Int>
)