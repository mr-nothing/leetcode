package solved.p966

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        InputData(
            arrayOf("KiTe", "kite", "hare", "Hare"),
            arrayOf("kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto")
        ) to arrayOf("kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe"),
        InputData(
            arrayOf("yellow"),
            arrayOf("YellOw")
        ) to arrayOf("yellow"),
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("Spell checker should transform ${inputData.queries.joinToString()} to ${expected.joinToString()} in accordance to dictionary ${inputData.wordlist.joinToString()}") {
            Assertions.assertArrayEquals(expected, Solution().spellchecker(inputData.wordlist, inputData.queries))
        }
    }

    private data class InputData(val wordlist: Array<String>, val queries: Array<String>)
}
