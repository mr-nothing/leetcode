package common

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        // Attempt to create binary tree builder similar to leet code one
        fun from(values: List<Int?>): TreeNode? {
            if (values.isEmpty() || values[0] == null) {
                return null
            }

            val valueQueue = LinkedList(values)

            val root = TreeNode(valueQueue.poll()!!)

            var currentLevel = mutableListOf<TreeNode?>(root)
            while (valueQueue.isNotEmpty()) {
                val newLevel = createChildren(currentLevel, valueQueue)
                currentLevel = newLevel
            }

            return root
        }

        private fun createChildren(
            currentLevel: MutableList<TreeNode?>,
            valueQueue: LinkedList<Int?>
        ): MutableList<TreeNode?> {
            val newLevel = mutableListOf<TreeNode?>()
            for (node in currentLevel) {
                node?.let {
                    node.left = valueQueue.poll()?.let {
                        TreeNode(it)
                    }
                    newLevel.add(node.left)
                    node.right = valueQueue.poll()?.let {
                        TreeNode(it)
                    }
                    newLevel.add(node.right)
                }
            }
            return newLevel
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TreeNode

        if (`val` != other.`val`) return false
        if (left != other.left) return false
        if (right != other.right) return false

        return true
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (left?.hashCode() ?: 0)
        result = 31 * result + (right?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return `val`.toString()
    }
}