package solved.p17

class Solution {
    /**
     * Pretty simple: We just recursively go through the digits in phone number and append corresponding chars to the
     * string builders. On each step we create separate output builder based on input builder appending each char
     * corresponding to the digit of the phone number.
     *
     * Example:
     * 263
     * - Current digit 2:
     *      - input builders    - ""
     *      - output builders   - "a", "b", "c"
     * - Current digit 6:
     *      - input builders    - "a", "b", "c"
     *      - output builders   - "am", "an", "ao", "bm", "bn", "bo", "cn", "cm", "co"
     * - Current digit 3:
     *      - input builders    - "am", "an", "ao", "bm", "bn", "bo", "cn", "cm", "co"
     *      - output builders   - "amd", "ame", "amf", "and", "ane", "anf", "aod", "aoe", "aof", "bmd", "bme", "bmf",
     *      "bnd", "bne", "bnf", "bod", "boe", "bof", "cnd", "cne", "cnf", "cmd", "cme", "cmf", "cod", "coe", "cof"
     *
     *  Done.
     */
    private val digitsMapping = mapOf(
        2 to listOf('a', 'b', 'c'),
        3 to listOf('d', 'e', 'f'),
        4 to listOf('g', 'h', 'i'),
        5 to listOf('j', 'k', 'l'),
        6 to listOf('m', 'n', 'o'),
        7 to listOf('p', 'q', 'r', 's'),
        8 to listOf('t', 'u', 'v'),
        9 to listOf('w', 'x', 'y', 'z')
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return listOf()
        }
        return combine(digits, "", 0)
    }

    private fun combine(phoneNumber: String, initial: String, digitIndex: Int): List<String> {
        val digit = Character.getNumericValue(phoneNumber[digitIndex])
        val chars = digitsMapping[digit] ?: throw IllegalArgumentException("Mapping for digit $digit is not found")
        val result = mutableListOf<String>()
        for (char in chars) {
            val continuation = StringBuilder(initial)
            continuation.append(char)
            if (digitIndex == phoneNumber.lastIndex) {
                result.add(continuation.toString())
            } else {
                result.addAll(combine(phoneNumber, continuation.toString(), digitIndex + 1))
            }
        }
        return result
    }
}