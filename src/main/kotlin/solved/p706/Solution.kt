package solved.p706

import java.util.*

class Solution {
    class MyHashMap() {
        private var currentSize = 0
        private var table = init(INITIAL_SIZE)

        private fun init(size: Int): Array<LinkedList<Pair<Int, Int>>> {
            return Array(size) { LinkedList() }
        }

        private fun resize() {
            val oldTable = table
            table = init(oldTable.size * 2)
            for (bucket in oldTable) {
                for (entry in bucket) {
                    put(entry.first, entry.second)
                }
            }
        }

        private fun hash(key: Int): Int {
            return key % table.size
        }

        fun put(key: Int, value: Int) {
            val bucket = table[hash(key)]
            val iterator = bucket.iterator()
            while (iterator.hasNext()) {
                val entry = iterator.next()
                if (entry.first == key) {
                    if (entry.second == value) {
                        return
                    } else {
                        iterator.remove()
                        currentSize--
                    }
                }
            }
            bucket.add(key to value)
            currentSize++
            if (currentSize > table.size * LOAD_FACTOR) {
                resize()
            }
        }

        fun get(key: Int): Int {
            val bucket = table[hash(key)]
            return bucket.firstOrNull { entry -> entry.first == key }?.second ?: -1
        }

        fun remove(key: Int) {
            val bucket = table[hash(key)]
            val iterator = bucket.iterator()
            while (iterator.hasNext()) {
                val entry = iterator.next()
                if (entry.first == key) {
                    iterator.remove()
                    currentSize--
                    return
                }
            }
        }

        companion object {
            private const val INITIAL_SIZE = 10000
            private const val LOAD_FACTOR = 0.75
        }
    }
}