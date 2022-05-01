package solved.p680

class Solution {
    fun validPalindrome(s: String): Boolean {
        var left = 0
        var right = s.lastIndex
        while (left < right) {
            if (s[left] != s[right]) {
                return validPalindromeInternal(s, left + 1, right) ||
                        validPalindromeInternal(s, left, right - 1)
            }
            left++
            right--
        }

        return true
    }

    private fun validPalindromeInternal(s: String, left: Int, right: Int): Boolean {
        var leftPointer = left
        var rightPointer = right
        while (leftPointer < rightPointer) {
            if (s[leftPointer] != s[rightPointer]) {
                return false
            }
            leftPointer++
            rightPointer--
        }

        return true
    }
}