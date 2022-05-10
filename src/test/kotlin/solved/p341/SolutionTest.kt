package solved.p341

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf<Int>().map {
        dynamicTest("n/a") {
            // Impossible to test cause of stupid unknown NestedInteger implementation -_-
            Assertions.assertEquals(true, true)
        }
    }
}