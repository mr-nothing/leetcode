package solved.p1418

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        listOf(
            listOf("David", "3", "Ceviche"),
            listOf("Corina", "10", "Beef Burrito"),
            listOf("David", "3", "Fried Chicken"),
            listOf("Carla", "5", "Water"),
            listOf("Carla", "5", "Ceviche"),
            listOf("Rous", "3", "Ceviche")
        ) to
                listOf(
                    listOf("Table", "Beef Burrito", "Ceviche", "Fried Chicken", "Water"),
                    listOf("3", "0", "2", "1", "0"),
                    listOf("5", "0", "1", "0", "1"),
                    listOf("10", "1", "0", "0", "0")
                ),
        listOf(
            listOf("James", "12", "Fried Chicken"),
            listOf("Ratesh", "12", "Fried Chicken"),
            listOf("Amadeus", "12", "Fried Chicken"),
            listOf("Adam", "1", "Canadian Waffles"),
            listOf("Brianna", "1", "Canadian Waffles")
        ) to
                listOf(
                    listOf("Table", "Canadian Waffles", "Fried Chicken"),
                    listOf("1", "2", "0"),
                    listOf("12", "0", "3")
                )
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The display table of ${inputData.joinToString { it.joinToString() }} should be ${expected.joinToString { it.joinToString() }}") {
            Assertions.assertEquals(expected, Solution().displayTable(inputData))
        }
    }
}