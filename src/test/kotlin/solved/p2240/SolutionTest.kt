package solved.p2240

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Triple(20, 10, 5) to 9L,
        Triple(5, 10, 10) to 1L
    ).map { (input, expected) ->
        val total = input.first
        val penPrice = input.second
        val pencilPrice = input.third
        DynamicTest.dynamicTest("The number of ways ${penPrice}$ pens and ${pencilPrice}$ pencils could be bought with ${total}$ should be $expected") {
            Assertions.assertEquals(expected, Solution().waysToBuyPensPencils(total, penPrice, pencilPrice))
        }
    }
}