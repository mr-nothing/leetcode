package p3

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        // Initialize length, from and to indexes
        var currentLength: Int
        var maxLength = 0
        var from = 0
        var to = 1

        // initialize map, containing indexes of sliding window
        val charIndexes = mutableMapOf<Char, Int>()

        if (s.isEmpty()) {
            return 0
        } else if (s.length == 1) {
            return 1
        } else {
            // Get char 1 from string
            var char1 = s[from]
            // Put char 1 index in map
            charIndexes[char1] = from

            // Get char 2 from string
            var char2 = s[to]

            while (true) {
                // Put char 2 index to map
                val char2Index = charIndexes[char2]
                charIndexes[char2] = to

                if (char2Index != null && char2Index >= from) {
                    currentLength = to - from
                    // Move start of the window to the position of found character dup
                    from = char2Index + 1
                } else {
                    currentLength = to - from + 1
                }
                // Move end of the window further
                to += 1

                if (currentLength > maxLength) {
                    maxLength = currentLength
                }

                // Check if we exceeded the max length of the original string
                if (to > s.length - 1) {
                    break
                }

                char1 = s[from]
                charIndexes[char1] = from

                char2 = s[to]
            }

            return maxLength
        }
    }
}