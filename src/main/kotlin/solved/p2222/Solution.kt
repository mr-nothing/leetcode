package solved.p2222

class Solution {
    fun numberOfWays(s: String): Long {
        var zero = 0L
        var one = 0L
        var zeroOne = 0L
        var oneZero = 0L
        var result = 0L
        for (ch in s) {
            if (ch == '0') {
                zero++
                oneZero += one
                result += zeroOne
            } else if (ch == '1') {
                one++
                zeroOne += zero
                result += oneZero
            } else {
                throw IllegalArgumentException("Illegal character found $ch")
            }
        }
        return result
    }
}