package p289

/** The idea is that we will store in original array:
 *  -1  for dead-alive transition
 *   0  for dead-dead transition
 *   1  for alive-alive transition
 *   2  for alive-dead transition
 */
class InPlaceSolution {
    class Solution {
        fun gameOfLife(board: Array<IntArray>) {
            for (i in 0..board.lastIndex) {
                for (j in 0..board[0].lastIndex) {
                    val currentValue = board[i][j]
                    val adjacentValue = adjacentSum(board, i, j)
                    if (currentValue == 1) {
                        if (adjacentValue < 2 || adjacentValue > 3) {
                            board[i][j] = 2
                        } else {
                            board[i][j] = 1
                        }
                    } else {
                        if (adjacentValue == 3) {
                            board[i][j] = -1
                        }
                    }
                }
            }

            for (i in 0..board.lastIndex) {
                for (j in 0..board[0].lastIndex) {
                    val currentValue = board[i][j]
                    if (currentValue == -1) {
                        board[i][j] = 1
                    } else if (currentValue == 2) {
                        board[i][j] = 0
                    }
                }
            }
        }

        private fun adjacentSum(arr: Array<IntArray>, i: Int, j: Int): Int {
            return adjValue(arr, i - 1, j - 1) +
                    adjValue(arr, i - 1, j) +
                    adjValue(arr, i - 1, j + 1) +
                    adjValue(arr, i, j - 1) +
                    adjValue(arr, i, j + 1) +
                    adjValue(arr, i + 1, j - 1) +
                    adjValue(arr, i + 1, j) +
                    adjValue(arr, i + 1, j + 1)
        }

        private fun adjValue(arr: Array<IntArray>, i: Int, j: Int): Int {
            if (i >= 0 && i <= arr.lastIndex && j >= 0 && j <= arr[0].lastIndex) {
                val value = arr[i][j]
                if (value == 1 || value == 2) {
                    return 1
                }
            }
            return 0
        }
    }
}