package solved.p12

class Solution {
    fun intToRoman(num: Int): String {
        if (num < 1 || num > 3999) {
            throw IllegalArgumentException("Argument doesn't correspond to the initial constrants")
        }

        var result = ""

        val thousands = num / 1000
        if (thousands > 0) {
            result += "M".repeat(thousands)
        }

        val hundreds = num % 1000 / 100
        if (hundreds in 1..3) {
            result += "C".repeat(hundreds)
        } else if (hundreds == 4) {
            result += "CD"
        } else if (hundreds in 5..8) {
            result = result + "D" + "C".repeat(hundreds - 5)
        } else if (hundreds == 9) {
            result += "CM"
        }

        val tens = num % 1000 % 100 / 10
        if (tens in 1..3) {
            result += "X".repeat(tens)
        } else if (tens == 4) {
            result += "XL"
        } else if (tens in 5..8) {
            result = result + "L" + "X".repeat(tens - 5)
        } else if (tens == 9) {
            result += "XC"
        }

        val ones = num % 1000 % 100 % 10
        if (ones in 1..3) {
            result += "I".repeat(ones)
        } else if (ones == 4) {
            result += "IV"
        } else if (ones in 5..8) {
            result = result + "V" + "I".repeat(ones - 5)
        } else if (ones == 9) {
            result += "IX"
        }

        return result
    }
}