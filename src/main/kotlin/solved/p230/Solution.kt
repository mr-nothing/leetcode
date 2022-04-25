package solved.p230

import common.TreeNode

class Solution {
    fun kthSmallest(root: TreeNode, k: Int): Int {
        return traverseInorder(root, k, mutableListOf()).last()
    }

    private fun traverseInorder(node: TreeNode, threshold: Int, kSmallest: MutableList<Int>): MutableList<Int> {
        node.left?.let {
            traverseInorder(it, threshold, kSmallest)
        }

        if (kSmallest.size == threshold) {
            return kSmallest
        }
        kSmallest.add(node.`val`)

        node.right?.let {
            traverseInorder(it, threshold, kSmallest)
        }

        return kSmallest
    }
}