package misc

import java.lang.Integer.min
import kotlin.random.Random

fun main() {
    for (i in 0..100) {
        var n = Math.pow(2.0, Random.nextInt(0, 6).toDouble()).toInt()
        val combined = List(n * 2) { it }
        val a = combined.take(n).toTypedArray()
        val b = combined.takeLast(n).toTypedArray()
        println(combined.joinToString())
        val algoResult = median(a, b, 0, n - 1, 0, n - 1)
        println("algorithm result: $algoResult")
        println("should actually be ${combined[combined.size / 2 - 1]}")
    }
}

fun median(a: Array<Int>, b: Array<Int>, startA: Int, endA: Int, startB: Int, endB: Int): Int {
    println("a: $startA, $endA, b: $startB, $endB")
    if (endA == startA && endB == startB) {
        return min(a[startA], b[startB])
    }
    val x = a[(startA + endA) / 2]
    val y = b[(startB + endB) / 2]
    println("middle a: ${(startA + endA) / 2} -> $x, middle b: ${(startB + endB) / 2} -> $y")
    if (x > y) {
        return median(a, b, startA, (startA + endA) / 2, (startB + endB) / 2 + 1, endB)
    } else {
        return median(a, b, (startA + endA) / 2 + 1, endA, startB, (startB + endB) / 2)
    }
}