package p703

class BucketSortSolution {
    class KthLargest(private val k: Int, nums: IntArray) {
        private var max = Int.MIN_VALUE
        private val buckets = IntArray(20001)

        init {
            for (num in nums) {
                addInternal(num)
            }
        }

        fun add(`val`: Int): Int {
            addInternal(`val`)
            var counter = k
            var i = max
            while (i >= -10000) {
                counter -= buckets[i + 10000]
                if (counter <= 0) {
                    return i
                }
                i--
            }
            throw IllegalStateException("Did not found $k max number")
        }

        private fun addInternal(num: Int) {
            buckets[num + 10000]++
            if (num > max) {
                max = num
            }
        }
    }
}