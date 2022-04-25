package solved.p284

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair(
            listOf("PeekingIterator", "next", "peek", "next", "next", "hasNext"),
            listOf(listOf(1, 2, 3), listOf(), listOf(), listOf(), listOf(), listOf())
        ) to listOf(null, 1, 2, 2, 3, false)
    ).map { (input, expected) ->
        val actions = input.first
        val values = input.second
        DynamicTest.dynamicTest("The actions $actions with values $values of peeking iterator should result to $expected") {
            val iterator = values[0].iterator()

            val peekingIterator = Solution.PeekingIterator(iterator)

            val actual = mutableListOf<Any?>()
            actual.add(null)

            for (commandIndex in 1..actions.lastIndex) {
                when (actions[commandIndex]) {
                    "next" -> {
                        actual.add(peekingIterator.next())
                    }
                    "peek" -> {
                        actual.add(peekingIterator.peek())
                    }
                    "hasNext" -> {
                        actual.add(peekingIterator.hasNext())
                    }
                    else -> {
                        throw IllegalArgumentException()
                    }
                }
            }

            assertEquals(expected, actual)
        }
    }
}