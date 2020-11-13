package misc

import kotlin.random.Random
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main() {
    testProblemTwo()
}

fun testProblemTwo() {
    for(i in 1..10000) {
        val array = (0..i).map { listOf(1, 2, 3).random() }.toTypedArray()
        val defaultSort = array.sorted()
        val timeTaken = measureNanoTime {
            specialSort(array)
        }
        println("ratio: ${timeTaken.toDouble() / i}")
        if(defaultSort != array.toList()) {
            println("disparity, should be $defaultSort but is $array")
        }
    }
}

fun specialSort(array: Array<Int>) {
    val endPos = runSortingAlgoInPlaceAt(0, 1, array)
    runSortingAlgoInPlaceAt(endPos, 2, array)
}

fun runSortingAlgoInPlaceAt(startAt: Int, firstPart: Int, array: Array<Int>): Int {
    var secondPos = array.lastIndex
    outer@for(firstPos in startAt..array.lastIndex) {
        if(firstPos == secondPos) {
            break
        }
        if(array[firstPos] != firstPart) {
            while(array[secondPos] != firstPart) {
                secondPos--
                if(secondPos == firstPos) {
                    break@outer
                }
            }
            val temp = array[secondPos]
            array[secondPos] = array[firstPos]
            array[firstPos] = temp
        }
    }
    return secondPos
}