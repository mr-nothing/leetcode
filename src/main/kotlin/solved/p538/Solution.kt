package solved.p538

import common.TreeNode

class Solution {
    fun convertBST(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        traverse(root, 0)

        return root
    }

    private fun traverse(node: TreeNode, sum: Int): Int {
        var currentSum = sum
        node.right?.let {
            currentSum = traverse(it, currentSum)
        }

        val increment = node.`val`
        node.`val` += currentSum
        currentSum += increment

        node.left?.let {
            currentSum = traverse(it, currentSum)
        }

        return currentSum
    }
}