package misc

import kotlin.random.Random

fun main() {
    for (i in 0..1000) {
        val n = Random.nextInt(1, 10)
        val array = List(n) { Random.nextInt(-n, n) }.toIntArray()
        val otherArray = intArrayOf(6, -7, -5, 1, 6, -2, -2, 2, -6)
        val algoResult = algo(otherArray)
        var actualResult = otherArray[0]
        for (x in 0 until n) {
            for (y in 0 until n) {
                if (x >= y) {
                    val sequence = otherArray.copyOfRange(y, x + 1)
                    val sum = sequence.sum()
                    if (sum > actualResult) {
                        actualResult = sum
                    }
                }
            }
        }
        if(algoResult != actualResult) {
            println("not equal")
            println(otherArray.joinToString())
            println("algo gave: $algoResult, actual: $actualResult")
            return
        }
    }
}

fun algo(array: IntArray): Int {
    println(array.joinToString())
    fun recurse(array: IntArray, start: Int, end: Int): Triple<Int, Int, Int> { //start, end, sum
        val half = start + (end - start) / 2
        println("$start, $end, $half")
        if (start >= end - 1) {
            println("reached base case for index $start, returning ${array[start]}")
            return Triple(start, end, array[start])
        }

        return Triple(0,0,0)
    }

    return recurse(array, 0, array.size).third
}