package p99

import common.TreeNode

class Solution {
    private var previousNode: TreeNode? = null
    private var first: TreeNode? = null
    private var second: TreeNode? = null

    fun recoverTree(root: TreeNode) {
        traverseInplace(root)

        if (first != null && second != null) {
            swapNodes(first!!, second!!)
        }
    }

    private fun traverseInplace(currentNode: TreeNode) {
        currentNode.left?.let {
            traverseInplace(it)
        }

        previousNode?.let {
            if (it.`val` > currentNode.`val`) {
                if (first == null) {
                    first = it
                }

                second = currentNode
            }
        }
        previousNode = currentNode

        currentNode.right?.let {
            traverseInplace(it)
        }
    }

    private fun swapNodes(first: TreeNode, second: TreeNode) {
        val temp = first.`val`
        first.`val` = second.`val`
        second.`val` = temp
    }
}