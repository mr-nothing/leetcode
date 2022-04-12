package p5

class Solution {
    fun longestPalindrome(s: String): String {
        var longestPalindrome = ""

        for (i in 0..s.lastIndex) {
            val ch = s[i]

            var left = i
            var right = i

            while(left >= 0 && s[left] == ch) {
                left--
            }
            left++

            while(right <= s.lastIndex && s[right] == ch) {
                right++
            }
            right--

            while (left >= 0 && right <= s.lastIndex && s[left] == s[right]) {
                left--
                right++
            }
            left++
            right--

            val currentPalindrome = s.substring(IntRange(left, right))
            if (currentPalindrome.length > longestPalindrome.length) {
                longestPalindrome = currentPalindrome
            }
        }

        return longestPalindrome
    }
}