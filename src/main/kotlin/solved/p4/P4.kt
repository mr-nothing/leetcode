package solved.p4

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val nums1Size = nums1.size
        val nums2Size = nums2.size

        val sizeGeneral = nums1Size + nums2Size
        val shouldDivide = sizeGeneral % 2 == 0
        val middleOfNums = sizeGeneral/2 + 1

        var i1 = 0
        var i2 = 0

        var previousNumber: Int? = null
        var currentNumber: Int? = null

        while(i1 + i2 < middleOfNums) {
            val num1 = if (i1 < nums1Size) { nums1[i1] } else null
            val num2 = if (i2 < nums2Size) { nums2[i2] } else null

            previousNumber = currentNumber
            if (num1 == null) {
                currentNumber = num2
                i2++
            } else if (num2 == null) {
                currentNumber = num1
                i1++
            } else {
                if (num1 <= num2) {
                    currentNumber = num1
                    i1++
                } else {
                    currentNumber = num2
                    i2++
                }
            }
        }

        return if (shouldDivide) {
            (previousNumber!!.toDouble() + currentNumber!!.toDouble()) / 2
        } else {
            currentNumber!!.toDouble()
        }
    }
}