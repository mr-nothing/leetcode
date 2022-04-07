package p1046

class BucketSortSolution {
    // Priority queue solution
    fun lastStoneWeight(stones: IntArray): Int {
        val buckets = IntArray(1001)

        for (stone in stones) {
            buckets[stone]++
        }

        var majorStoneValue = 1000
        var minorStoneValue: Int
        while(majorStoneValue > 0) {
            val majorBucketValue = buckets[majorStoneValue]
            if (majorBucketValue % 2 != 0) {
                minorStoneValue = majorStoneValue - 1
                while (minorStoneValue > 0 && buckets[minorStoneValue] == 0) {
                    minorStoneValue--
                }
                if (minorStoneValue == 0) {
                    break
                }
                buckets[minorStoneValue]--
                buckets[majorStoneValue - minorStoneValue]++
            }
            majorStoneValue--
        }

        return majorStoneValue
    }
}