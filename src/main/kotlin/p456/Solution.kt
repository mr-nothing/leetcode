package p456

import java.util.*

class Solution {
    // The idea is to go the array from the tail to the head and use stack as a buffer for the "3" candidates numbers:
    // those in the center of 132 pattern. The latest "2" candidate is stored in the 'middle' variable.
    // If we find an element that is lower than middle then we are done and found 132 pattern.
    fun find132pattern(nums: IntArray): Boolean {
        val stack = LinkedList<Int>()

        var middle = Int.MIN_VALUE

        for (index in nums.lastIndex downTo 0) {
            val num = nums[index]
            if (num < middle) {
                return true
            }
            while (stack.isNotEmpty() && stack.peek() < num) {
                middle = stack.pop()
            }
            stack.push(num)
        }

        return false
    }
}