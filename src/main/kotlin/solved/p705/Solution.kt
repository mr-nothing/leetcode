package solved.p705

class Solution {
    class MyHashSet {
        private var currentSize = 0
        private var buckets: Array<MutableList<Int>>

        init {
            buckets = Array(INITIAL_SIZE) { mutableListOf<Int>() }
        }

        fun add(key: Int) {
            val hash = hash(key)
            val bucket = buckets[hash]
            if (bucket.contains(key)) {
                return
            }
            bucket.add(key)
            currentSize++

            if (currentSize >= LOAD_FACTOR * buckets.size) {
                resize()
            }
        }

        fun remove(key: Int) {
            val hash = hash(key)
            val bucket = buckets[hash]
            val removed = bucket.remove(key)
            if (removed) {
                currentSize--
            }
        }

        fun contains(key: Int): Boolean {
            val hash = hash(key)
            val entry = buckets[hash]
            return entry.contains(key)
        }

        private fun resize() {
            val oldBuckets = buckets
            buckets = Array(oldBuckets.size * 2) { mutableListOf<Int>() }
            for (oldBucket in oldBuckets) {
                for (value in oldBucket) {
                    add(value)
                }
            }
        }

        private fun hash(key: Int): Int {
            return key % buckets.size
        }

        companion object {
            private const val LOAD_FACTOR = 0.7
            private const val INITIAL_SIZE = 100
        }
    }
}