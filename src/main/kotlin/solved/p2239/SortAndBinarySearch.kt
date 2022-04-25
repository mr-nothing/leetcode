package solved.p2239

import kotlin.math.abs

class SortAndBinarySearch {
    class Solution {
        fun findClosestNumber(nums: IntArray): Int {
            val sorted = nums.sorted()
            val index = sorted.binarySearch(0)

            return if (index > 0) {
                sorted[index]
            } else {
                val rightClosest = abs(index + 1)
                val leftClosest = rightClosest - 1
                if (leftClosest < 0) {
                    return sorted[rightClosest]
                } else if (rightClosest > sorted.lastIndex) {
                    return sorted[leftClosest]
                } else {
                    val first = sorted[leftClosest]
                    val second = sorted[rightClosest]
                    if (abs(first) > abs(second)) {
                        return second
                    } else if (abs(first) < abs(second)) {
                        return first
                    } else {
                        if (first > second) first else second
                    }
                }
            }
        }
    }
}