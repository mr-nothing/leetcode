package p682

class Solution {
    fun calPoints(ops: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        var sum = 0

        for (operation in ops) {
            with(operation) {
                when {
                    equals("+") -> {
                        val last = stack[stack.lastIndex]
                        val preLast = stack[stack.lastIndex - 1]

                        val stepResult = last + preLast
                        stack.addLast(stepResult)
                        sum += stepResult
                    }
                    equals("C") -> {
                        val stepResult = stack.removeLast()
                        sum -= stepResult
                    }
                    equals("D") -> {
                        val stepResult = stack.last() * 2
                        stack.addLast(stepResult)
                        sum += stepResult
                    }
                    else -> {
                        val stepResult = operation.toInt()
                        stack.addLast(stepResult)
                        sum += stepResult
                    }
                }
            }
        }

        return sum
    }
}