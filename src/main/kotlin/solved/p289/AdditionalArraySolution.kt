package solved.p289

class AdditionalArraySolution {
    class Solution {
        fun gameOfLife(board: Array<IntArray>) {
            val adj = Array(board.size) { IntArray(board[0].size) }

            for (i in 0..board.lastIndex) {
                for (j in 0..board[0].lastIndex) {
                    val currentValue = board[i][j]
                    if (currentValue == 1) {
                        spread(adj, i, j)
                    }
                }
            }

            for (i in 0..board.lastIndex) {
                for (j in 0..board[0].lastIndex) {
                    val currentValue = board[i][j]
                    val adjacentValue = adj[i][j]
                    if (currentValue == 1) {
                        if (adjacentValue < 2 || adjacentValue > 3) {
                            board[i][j] = 0
                        } else {
                            board[i][j] = 1
                        }
                    } else {
                        if (adjacentValue == 3) {
                            board[i][j] = 1
                        }
                    }
                }
            }
        }

        fun spread(arr: Array<IntArray>, i: Int, j: Int) {
            increment(arr, i - 1, j - 1)
            increment(arr, i - 1, j)
            increment(arr, i - 1, j + 1)
            increment(arr, i, j - 1)
            increment(arr, i, j + 1)
            increment(arr, i + 1, j - 1)
            increment(arr, i + 1, j)
            increment(arr, i + 1, j + 1)
        }

        private fun increment(arr: Array<IntArray>, i: Int, j: Int) {
            if (i >= 0 && i <= arr.lastIndex && j >= 0 && j <= arr[0].lastIndex) {
                arr[i][j] += 1
            }
        }
    }
}