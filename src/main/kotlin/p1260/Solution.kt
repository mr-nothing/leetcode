package p1260

class Solution {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val innerSize = grid[0].size
        val outerSize = grid.size
        val normK = k % (innerSize * outerSize)

        if (normK % (innerSize * outerSize) == 0) {
            // return as is since no rotation required in case k equals to innerSize * outerSize
            return grid.map { it.toList() }.toList()
        } else if (normK % innerSize == 0) {
            // swap only rows since we don't need to make any changes inside any row
            val rowShiftDistance = (normK / innerSize) % outerSize
            val result = mutableListOf<List<Int>>()
            for (i in 0 until outerSize) {
                result.add(listOf())
            }
            for (i in 0..grid.lastIndex) {
                val innerArray = grid[i]
                val destinationRowIndex = if (i + rowShiftDistance > outerSize - 1) (i + rowShiftDistance) % outerSize  else i + rowShiftDistance
                result[destinationRowIndex] = innerArray.toList()
            }
            return result
        } else {
            var destI = (normK / innerSize) % outerSize
            var destJ = normK % innerSize

            val result = mutableListOf<MutableList<Int>>()
            for (i in 0 until outerSize) {
                result.add(MutableList(innerSize) { 0 })
            }
            var currentList = result[destI]

            for (i in 0 until outerSize) {
                val row = grid[i]
                for (j in 0 until innerSize) {
                    val value = row[j]

                    currentList[destJ] = value
                    if (destJ == innerSize - 1) {
                        if (destI == outerSize - 1) {
                            destI = 0
                        } else {
                            destI++
                        }
                        currentList = result[destI]
                        destJ = 0
                    } else {
                        destJ++
                    }
                }
            }

            return result
        }
    }
}