package solved.p284

class Solution {
    class PeekingIterator(iterator: Iterator<Int>) : Iterator<Int> {
        private val internalIterator: Iterator<Int> = iterator
        private var next: Int? = null
        private var end = false

        init {
            maintainState()
        }

        fun peek(): Int {
            return next!!
        }

        override fun next(): Int {
            val result = next
            maintainState()
            return result!!
        }

        override fun hasNext(): Boolean {
            return !end
        }

        private fun maintainState() {
            if (internalIterator.hasNext()) {
                next = internalIterator.next()
            } else {
                end = true
            }
        }
    }
}