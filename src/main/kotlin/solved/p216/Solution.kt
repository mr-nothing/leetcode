package solved.p216

class Solution {
    /**
     * The idea is to go through the array of digits using backtracking technique.
     * Stop condition for:
     * - correct solution is (k == 0 AND n == 0)
     * - incorrect solution is (k == 0 AND n != 0) OR n < 0
     */
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        combination(ans, mutableListOf(), k, 1, n)
        return ans
    }

    private fun combination(result: MutableList<List<Int>>, combination: MutableList<Int>, k: Int, start: Int, n: Int) {
        if (combination.size == k && n == 0) {
            result.add(combination.toMutableList())
            return
        }
        if (combination.size == k || n < 0) {
            return
        }
        for (i in start..9) {
            combination.add(i)
            combination(result, combination, k, i + 1, n - i)
            combination.removeAt(combination.lastIndex)
        }
    }
}