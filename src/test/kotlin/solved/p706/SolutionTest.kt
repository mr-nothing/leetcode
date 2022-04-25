package solved.p706

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair(
            listOf("MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"),
            listOf(
                listOf(),
                listOf(1, 1),
                listOf(2, 2),
                listOf(1),
                listOf(3),
                listOf(2, 1),
                listOf(2),
                listOf(2),
                listOf(2)
            )
        ) to listOf(null, null, null, 1, -1, null, 1, null, -1)
    ).map { (input, expected) ->
        val actions = input.first
        val values = input.second
        DynamicTest.dynamicTest("The result of actions $actions performed with values $values on hash map should be $expected") {
            val hashMap = Solution.MyHashMap()

            val actual = mutableListOf<Int?>()
            actual.add(null)

            for (index in 1..actions.lastIndex) {
                val action = actions[index]
                val value = values[index]

                actual.add(
                    when (action) {
                        "put" -> {
                            hashMap.put(value[0], value[1])
                            null
                        }
                        "get" -> {
                            hashMap.get(value[0])
                        }
                        "remove" -> {
                            hashMap.remove(value[0])
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