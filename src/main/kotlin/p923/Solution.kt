package p923

class Solution {
    fun threeSumMulti(arr: IntArray, target: Int): Int {
        val modulo = 1000000007
        var tuples: Long = 0

        val sorted = arr.sorted()
        for (i in sorted.indices) {
            val sumOfTwo = target - sorted[i]
            var leftPointer = i + 1
            var rightPointer = sorted.size - 1
            while (leftPointer < rightPointer) {
                // Try to count possible variants of sum of two values, the idea is similar to p5 (longest palindrome)
                if (sorted[leftPointer] + sorted[rightPointer] < sumOfTwo) {
                    leftPointer++
                } else if (sorted[leftPointer] + sorted[rightPointer] > sumOfTwo) {
                    rightPointer--
                } else if (sorted[leftPointer] != sorted[rightPointer]) {
                    var leftDups = 1
                    var rightDups = 1
                    while (leftPointer + 1 < rightPointer && sorted[leftPointer] == sorted[leftPointer + 1]) {
                        leftDups++
                        leftPointer++
                    }
                    while (rightPointer - 1 > leftPointer && sorted[rightPointer] == sorted[rightPointer - 1]) {
                        rightDups++
                        rightPointer--
                    }
                    tuples += (leftDups * rightDups).toLong()
                    tuples %= modulo.toLong()
                    leftPointer++
                    rightPointer--
                } else {
                    // This is the case for the center of array. Both pointers are in the area where current value
                    // doesn't change anymore, and we need just to count all possible variants of remaining numbers.
                    tuples += ((rightPointer - leftPointer + 1) * (rightPointer - leftPointer) / 2).toLong()
                    tuples %= modulo.toLong()
                    break
                }
            }
        }
        return tuples.toInt()
    }
}