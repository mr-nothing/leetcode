package solved.p167

class Solution {
    /**
     * The idea of this solution is to maintain two pointers: one from the head and another from the tail of the input array.
     * We move them towards the center of the array based on the sum of the elements at both pointers' positions.
     * 1) If the sum is greater than the target, then we need to make sum a lower number, so we move tail to the left
     * 2) If the sum is lower than the target, then we need to make sum a greater number, so we move head to the right
     * 3) If the sum is equal to target - we found a solution.
     */
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var head = 0
        var tail = numbers.lastIndex

        while (head < tail) {
            val headValue = numbers[head]
            val tailValue = numbers[tail]

            val sum = headValue + tailValue
            if (sum > target) {
                tail--
            } else if (sum < target) {
                head++
            } else {
                return intArrayOf(head + 1, tail + 1)
            }
        }
        throw IllegalStateException("No solution found")
    }
}