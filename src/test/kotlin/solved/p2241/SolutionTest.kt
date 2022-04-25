package solved.p2241

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair(
            listOf("ATM", "deposit", "withdraw", "deposit", "withdraw", "withdraw"),
            listOf(listOf(), listOf(0, 0, 1, 2, 1), listOf(600), listOf(0, 1, 0, 1, 1), listOf(600), listOf(550))
        ) to listOf(null, null, listOf(0, 0, 1, 0, 1), null, listOf(-1), listOf(0, 1, 0, 0, 1)),
        Pair(
            listOf("ATM", "deposit", "withdraw"),
            listOf(listOf(), listOf(0, 10, 0, 3, 0), listOf(500))
        ) to listOf(null, null, listOf(0, 2, 0, 2, 0)),
    ).map { (input, expected) ->
        val actions = input.first
        val values = input.second
        dynamicTest("The result of actions $actions with [$values values on ATM machine should be $expected") {
            val atm = Solution.ATM()
            val actual = mutableListOf<MutableList<Int>?>()
            actual.add(null)

            for (i in 1..actions.lastIndex) {
                val action = actions[i]
                val value = values[i]
                when (action) {
                    "deposit" -> {
                        atm.deposit(value.toIntArray())
                        actual.add(null)
                    }
                    "withdraw" -> {
                        actual.add(atm.withdraw(value[0]).toMutableList())
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