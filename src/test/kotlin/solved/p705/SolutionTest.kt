package solved.p705

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair(
            listOf("MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"),
            listOf(null, 1, 2, 1, 3, 2, 2, 2, 2)
        ) to listOf(null, null, null, true, false, null, true, null, false)
    ).map { (input, expected) ->
        val actions = input.first
        val values = input.second
        DynamicTest.dynamicTest("The result of actions $actions performed with values $values on hash set should be $expected") {
            val hashSet = Solution.MyHashSet()

            val actual = mutableListOf<Boolean?>()
            actual.add(null)

            for (index in 1..actions.lastIndex) {
                val action = actions[index]
                val value = values[index]!!

                actual.add(
                    when (action) {
                        "add" -> {
                            hashSet.add(value)
                            null
                        }
                        "contains" -> {
                            hashSet.contains(value)
                        }
                        "remove" -> {
                            hashSet.remove(value)
                            null
                        }
                        else -> {
                            throw IllegalArgumentException()
                        }
                    }
                )
            }

            Assertions.assertEquals(expected, actual)
        }
    }
}