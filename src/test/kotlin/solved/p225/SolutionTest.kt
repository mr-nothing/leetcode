package solved.p225

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair(
            listOf("MyStack", "push", "push", "top", "pop", "empty"),
            listOf(null, 1, 2, null, null, null)
        ) to listOf(null, null, null, 2, 2, false)
    ).map { (input, expected) ->
        dynamicTest("Operations on stack ${input.first} with arguments ${input.second} should result to $expected") {
            val stack = Solution.MyStack()
            val operations = input.first
            val values = input.second

            val resultList = mutableListOf<Any?>()
            resultList.add(null)
            for (index in 1..input.first.lastIndex) {
                val operation = operations[index]
                val value = values[index]

                val result: Any? = when (operation) {
                    "push" -> {
                        stack.push(value!!)
                        null
                    }
                    "top" -> stack.top()
                    "pop" -> stack.pop()
                    "empty" -> stack.empty()
                    else -> throw IllegalArgumentException()
                }

                resultList.add(result)
            }

            assertEquals(expected, resultList)
        }
    }
}