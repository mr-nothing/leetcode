package template

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        "" to 12
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("") {

        }
    }
}