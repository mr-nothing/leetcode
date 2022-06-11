package p2299

class Solution {
    fun strongPasswordCheckerII(password: String): Boolean {
        var hasLowerCase = false
        var hasUpperCase = false
        var hasDigit = false
        var hasSpecialChar = false
        var hasSimilarAdjacentChars = false

        var previousChar: Char? = null

        if (password.length < 8) {
            return false
        }

        for (char in password) {
            if (!hasLowerCase && char.isLowerCase()) {
                hasLowerCase = true
            }

            if (!hasUpperCase && char.isUpperCase()) {
                hasUpperCase = true
            }

            if (!hasDigit && char.isDigit()) {
                hasDigit = true
            }

            if (!hasSpecialChar && listOf('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+').contains(char)) {
                hasSpecialChar = true
            }

            if (!hasSimilarAdjacentChars && char == previousChar) {
                hasSimilarAdjacentChars = true
            }



            previousChar = char
        }

        return hasLowerCase && hasUpperCase && hasDigit && hasSpecialChar && !hasSimilarAdjacentChars
    }
}