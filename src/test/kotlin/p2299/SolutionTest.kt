package p2299

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        "IloveLe3tcode!" to true,
        "Me+You--IsMyDream" to false,
        "1aB!" to false
    ).map { (input, expected) ->
        val not = if (expected) "" else "not"
        dynamicTest("The password $input should $not be treated as a strong one") {
            assertEquals(expected, Solution().strongPasswordCheckerII(input))
        }
    }
}