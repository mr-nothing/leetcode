package solved.p341

import java.util.*

class Solution {
    /**
     * All the logic is concentrated in findNext() method.
     * At the beginning it checks if next variable is set. If it is then it just quites, cause this value was not used yet.
     * After that it starts its logic with removing all empty iterators in the stack until it finds NestedInteger object.
     *
     * Then if we meet NestedInteger that represents:
     * 1. integer then store it in next variable.
     * 2. list of NestedInteger's then push iterator in the stack and start findNext() process from the beginning.
     * findNext() is called whenever
     * After this process:
     * next()       method returns next variable and then resets it.
     * hasNext()    method just do the null check of next variable and return this as a result.
     *
     * Side note:
     *  This solution operates a lot with the state of the object, and I don't feel it follow kotlin's best practices,
     *  but in my opinion it is more valuable to follow next/hasNext contract.
     */
    class NestedIterator(nestedList: List<NestedInteger>) {
        private val stack = LinkedList<Iterator<NestedInteger>>()
        private var next: Int? = null

        init {
            stack.add(nestedList.iterator())
        }

        fun next(): Int {
            findNext()
            if (next != null) {
                val temp = next
                next = null
                return temp!!
            }
            throw NoSuchElementException()
        }

        fun hasNext(): Boolean {
            findNext()
            return next != null
        }

        private fun findNext() {
            if (next != null) {
                return
            }
            if (stack.isEmpty()) {
                next = null
            }
            while (stack.isNotEmpty() && !stack.peek().hasNext()) {
                stack.pop()
            }
            if (stack.isNotEmpty()) {
                val ni = stack.peek().next()
                if (ni.isInteger()) {
                    next = ni.getInteger()!!
                    return
                } else {
                    stack.push(ni.getList()!!.iterator())
                    findNext()
                }
            }
            return
        }
    }

    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        fun isInteger(): Boolean

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        fun getInteger(): Int?

        // Set this NestedInteger to hold a single integer.
        fun setInteger(value: Int): Unit

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        fun add(ni: NestedInteger): Unit

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        fun getList(): List<NestedInteger>?
    }
}