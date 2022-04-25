package solved.p173

import common.TreeNode
import java.util.*

class Solution {
    class BSTIterator(root: TreeNode) {
        private val traverseStack = LinkedList<TreeNode>()

        init {
            traverseLeft(root)
        }

        private fun traverseLeft(node: TreeNode) {
            traverseStack.push(node)
            node.left?.let {
                traverseLeft(it)
            }
        }

        private fun traverseRight(node: TreeNode) {
            node.right?.let { right ->
                traverseStack.push(right)
                right.left?.let { left ->
                    traverseLeft(left)
                }
            }
        }

        fun next(): Int {
            val minNode = traverseStack.poll()
            traverseRight(minNode)
            return minNode.`val`
        }

        fun hasNext(): Boolean {
            return traverseStack.peek() != null
        }
    }
}