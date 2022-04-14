package solved.p1312

class Solution {
    fun minInsertions(s: String): Int {

        for (i in 0..s.lastIndex) {
            val queue = ArrayDeque<Int>()
        }

        return 0
    }

//    fun minInsertions(s: String): Int {
//
//        if (s.length == 1) {
//            return 0
//        }
//
//        var leftEnd = 0
//        var rightStart = 1
//
//        val charMapBeforePoint = mutableMapOf<Char, Int>()
//
//        val charMapAfterPoint = mutableMapOf<Char, Int>()
//        for (i in rightStart..s.lastIndex) {
//            val ch = s[i]
//            val frequency = charMapAfterPoint[ch]
//            if (frequency == null) {
//                charMapAfterPoint[ch] = 1
//            } else {
//                charMapAfterPoint[ch] = frequency + 1
//            }
//        }
//
//        var minInsertions = calculateInsertions(charMapBeforePoint, charMapAfterPoint)
//
//        while(rightStart < s.lastIndex) {
//            val gapBeforePoint = s[leftEnd]
//            val gapAfterPoint = s[rightStart]
//
//            if (leftEnd != rightStart) {
//                val charFrequencyBefore = charMapBeforePoint.getOrDefault(gapBeforePoint, 0)
//                charMapBeforePoint[gapBeforePoint] = charFrequencyBefore + 1
//            } else {
//                val charFrequencyAfterPoint = charMapAfterPoint[gapAfterPoint]
//                    ?: throw IllegalStateException("Char frequency after point can not be null")
//                if (charFrequencyAfterPoint - 1 == 0) {
//                    charMapAfterPoint.remove(gapAfterPoint)
//                } else {
//                    charMapAfterPoint[gapAfterPoint] = charFrequencyAfterPoint - 1
//                }
//            }
//
//            val currentInsertions = calculateInsertions(charMapBeforePoint, charMapAfterPoint)
//
//            if (currentInsertions < minInsertions) {
//                minInsertions = currentInsertions
//            }
//            if (minInsertions == 0) {
//                break
//            }
//
//            if (leftEnd == rightStart) {
//                rightStart++
//            } else {
//                leftEnd++
//            }
//        }
//
//        return minInsertions
//    }
//
//    private fun calculateInsertions(
//        charMapBeforePoint: MutableMap<Char, Int>,
//        charMapAfterPoint: MutableMap<Char, Int>
//    ): Int {
//        var currentInsertions = 0
//        for (charBeforePoint in charMapBeforePoint.entries) {
//            val charsQuantityAfterPoint = charMapAfterPoint[charBeforePoint.key]
//            val charsQuantityBeforePoint = charBeforePoint.value
//            currentInsertions += if (charsQuantityAfterPoint != null) {
//                abs(charsQuantityBeforePoint - charsQuantityAfterPoint)
//            } else {
//                charsQuantityBeforePoint
//            }
//        }
//        for (charAfterPoint in charMapAfterPoint.entries) {
//            val charsQuantityBeforePoint = charMapBeforePoint[charAfterPoint.key]
//            val charsQuantityAfterPoint = charAfterPoint.value
//            if (charsQuantityBeforePoint == null) {
//                currentInsertions += charsQuantityAfterPoint
//            }
//        }
//        return currentInsertions
//    }
}