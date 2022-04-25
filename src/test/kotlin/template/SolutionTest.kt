package template

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        "" to 12
    ).map { (input, expected) ->
        dynamicTest("") {
            assertEquals(true, true)
        }
    }
}