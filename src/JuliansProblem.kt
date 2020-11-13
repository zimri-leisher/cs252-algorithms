package misc

import java.lang.Math.sqrt
import kotlin.random.Random

fun main() {
    for(i in 0..1000) {
        val n = Random.nextInt(1, 1000)
        val total = List(n) {
            Random.nextInt(0, 10000) to Random.nextBoolean()
        }
        val a = total.filter { it.second }.map { it.first }.toTypedArray()
        val b = total.filter { !it.second }.map { it.first }.toTypedArray()
        test(a, b)
    }
}

fun test(a: Array<Int>, b: Array<Int>) {
    val combinedLength = sqrt(a.sumByDouble { it * it.toDouble() } + b.sumByDouble { it * it.toDouble() })
    val separateLength = sqrt(a.sumByDouble { it * it.toDouble() }) + sqrt(b.sumByDouble { it * it.toDouble() })
    if(combinedLength >= separateLength * (sqrt(2.0)/2 - 0.001)) {
        println("true! ratio: ${combinedLength / separateLength}")
    } else {
        println("false :( ratio: ${combinedLength / separateLength}")
    }
}