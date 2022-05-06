package solved.p1286

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair(listOf("next", "hasNext", "next", "hasNext", "next", "hasNext"), listOf("abc", 2)) to listOf(
            "ab",
            true,
            "ac",
            true,
            "bc",
            false
        )
    ).map { (input, expected) ->
        dynamicTest("Operations ${input.first} on combination iterator initialized with ${input.second} should result in $expected") {
            val combinationIterator = Solution.CombinationIterator(input.second[0] as String, input.second[1] as Int)
            val operations = input.first

            val resultList = mutableListOf<Any>()
            for (operation in operations) {
                val result = when (operation) {
                    "next" -> combinationIterator.next()
                    "hasNext" -> combinationIterator.hasNext()
                    else -> throw IllegalArgumentException()
                }

                resultList.add(result)
            }

            assertEquals(expected, resultList)
        }
    }
}