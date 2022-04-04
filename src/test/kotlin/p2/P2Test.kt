package p2

import common.ListNode
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
            val actual = Solution().addTwoNumbers(ListNode.from(input.l1), ListNode.from(input.l2))

            assertEquals(output.l, ListNode.to(actual))
        }
    }
}

data class TestInput(
    val l1: List<Int>,
    val l2: List<Int>
)

data class TestOutput(
    val l: List<Int>
)