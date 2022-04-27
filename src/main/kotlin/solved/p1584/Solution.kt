package solved.p1584

import java.util.*
import kotlin.math.abs

class Solution {
    class PrimAlgorithm {
        private val edges = PriorityQueue<Edge> { e1, e2 -> e1.weight.compareTo(e2.weight) }
        private val visited = mutableSetOf<Point>()

        fun minCostConnectPoints(pointsCoordinates: Array<IntArray>): Int {
            val points = pointsCoordinates.map { Point(it[0], it[1]) }

            if (points.size <= 1) {
                return 0
            }

            var result = 0
            var currentPoint = points.first()
            for (pointIndex in 1..points.lastIndex) {
                val anotherPoint = points[pointIndex]
                edges.offer(Edge(currentPoint, anotherPoint))
            }
            visited.add(currentPoint)

            while (true) {
                val minEdge = edges.poll()
                currentPoint = minEdge.to

                if (!visited.contains(currentPoint)) {
                    result += minEdge.weight
                    visited.add(currentPoint)
                    points.forEach {
                        if (!visited.contains(it)) {
                            edges.offer(Edge(currentPoint, it))
                        }
                    }
                }
                if (edges.isEmpty() || visited.size == points.size) {
                    break
                }
            }

            return result
        }
    }

    data class Point(val x: Int, val y: Int) {
        fun distanceTo(that: Point): Int {
            return abs(x - that.x) + abs(y - that.y)
        }
    }

    data class Edge(val from: Point, val to: Point) {
        val weight: Int = from.distanceTo(to)
    }
}