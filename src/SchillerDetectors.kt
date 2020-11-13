package misc

import kotlin.math.ceil
import kotlin.random.Random

fun main() {
    for (i in 0..0) {
        val length = Random.nextInt(1, 47)
        val n = Random.nextInt(1, 10)
        val positions = List(n) { Random.nextDouble(0.0, length.toDouble()) }
        val result = algo(length, positions)
        println("for length $length, n=$n, and positions ${positions.sorted()}, the algorithm gives ${result}")
        println("min possible: ${ceil(length / 9.4)}, actual: ${result?.size}")
        println("could there possibly be a solution? ${length / 9.4 <= n}")
    }
}

fun algo(length: Int, possiblePositions: List<Double>): List<Double>? {
    val usedPositions = mutableListOf<Double>()
    var solvedUpTo = 0.0
    val sortedPossiblePositions = possiblePositions.sortedDescending()
    while (usedPositions.size < possiblePositions.size) {
        val next = sortedPossiblePositions.firstOrNull { it - 4.7 <= solvedUpTo } ?: return null
        usedPositions.add(next)
        solvedUpTo = next + 4.7
        if (solvedUpTo > length) {
            return usedPositions
        }
    }
    return null
}