package misc

import kotlin.random.Random

fun main() {
    for (i in 0..1000) {
        val n = Random.nextInt(3, 20)
        val testCase = List(n) { List(n) { Random.nextBoolean() }.toTypedArray() }.toTypedArray()
        val generateBigWig = Random.nextBoolean()
        val bigWigAt: Int
        if(generateBigWig) {
            bigWigAt = Random.nextInt(0, n)
            for(x in 0 until n) {
                testCase[x][bigWigAt] = true
            }
            for(y in 0 until n) {
                testCase[bigWigAt][y] = false
            }
        } else {
            bigWigAt = -1
        }
        val at = testAlgo(testCase)
        println(at)
        println("should be at $bigWigAt")
        if(at != bigWigAt && bigWigAt != -1) {
            println("NOT")
            println(testCase.joinToString { "\n" + it.joinToString() })
            return
        }
    }
}

fun testAlgo(matrix: Array<Array<Boolean>>): Int {
    val n = matrix.size
    var x = 0
    var y = 1
    while (y < n) {
        println("checking $x, $y: ${matrix[y][x]}")
        if (!matrix[y][x]) {
            println("can't be $x")
            x = y
        } else {
            println("can't be $y")
        }
        y++
    }
    for (yPrime in 0 until n) {
        if (x != yPrime && !matrix[yPrime][x]) {
            println("SJDKLFKLJSFD $x $y")
            return -1
        }
    }
    for (xPrime in 0 until n) {
        if (x != xPrime && matrix[x][xPrime]) {
            println("JKSDFLJKSFD $x $y")
            return -1
        }
    }
    return x
}