package p11

import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {

        var maxArea = 0
        var leftCounter = 0
        var rightCounter = height.lastIndex
        while (rightCounter - leftCounter > 0) {
            val leftHeight = height[leftCounter]
            val rightHeight = height[rightCounter]
            val currentArea = (rightCounter - leftCounter) * min(leftHeight, rightHeight)

            if (currentArea > maxArea) {
                maxArea = currentArea
            }

            if (leftHeight > rightHeight) {
                rightCounter--
            } else if (rightHeight > leftHeight) {
                leftCounter++
            } else {
                rightCounter--
                leftCounter++
            }
        }

        return maxArea

    }
}