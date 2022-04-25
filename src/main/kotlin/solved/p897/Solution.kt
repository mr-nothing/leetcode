package solved.p897

import common.TreeNode

class Solution {
    private var newRoot: TreeNode? = null
    private var newTail: TreeNode? = null

    fun increasingBST(root: TreeNode?): TreeNode? {
        traverseSubtree(root!!)
        return newRoot
    }

    private fun traverseSubtree(node: TreeNode) {
        node.left?.let { left ->
            traverseSubtree(left)
        }

        if (newTail == null || newRoot == null) {
            val minNode = TreeNode(node.`val`)
            newRoot = minNode
            newTail = minNode
        } else {
            newTail!!.right = TreeNode(node.`val`)
            newTail = newTail!!.right
        }

        node.right?.let { right ->
            traverseSubtree(right)
        }
    }
}