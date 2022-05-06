package solved.p1286

import java.util.*

class Solution {
    class CombinationIterator(val characters: String, val combinationLength: Int) {
        private var stack: Stack<Int> = Stack<Int>()
        private var chars: CharArray = characters.toCharArray()

        init {
            for (i in 0 until combinationLength) {
                stack.push(i)
            }
        }

        fun next(): String {
            if (!hasNext()) return ""
            val sb = StringBuilder()
            for (i in 0 until combinationLength) {
                sb.append(chars[stack[i]])
            }
            if (stack.peek() < combinationLength - 1) {
                stack[stack.size - 1] = stack.peek() + 1
            } else {
                while (!stack.isEmpty() && stack.peek() >= chars.size - combinationLength + stack.size - 1) {
                    stack.pop()
                }
                if (!stack.isEmpty()) {
                    stack[stack.size - 1] = stack.peek() + 1
                    val size = combinationLength - stack.size
                    for (i in 0 until size) {
                        stack.push(stack.peek() + 1)
                    }
                }
            }
            return sb.toString()
        }

        fun hasNext(): Boolean {
            return !stack.isEmpty()
        }

    }
}