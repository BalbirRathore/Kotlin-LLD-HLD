package org.example.geeksforgeeks.array

fun main(args: Array<String>) {
    val array = intArrayOf(12, 1234, 45, 67, 1)
    //val array = intArrayOf(12)
    val minMaxArray = findMinMax(array)
    println("min==${minMaxArray[0]}")
    println("max==${minMaxArray[1]}")
}

fun findMin(array: IntArray) :Int{
    var min = array[0]
    for (i in 1 until  array.size)
        min = min.coerceAtMost(array[i])
    return min
}

fun findMax(array: IntArray) :Int{
    var max = array[0]
    for (i in 1 until  array.size)
        max = max.coerceAtLeast(array[i])
    return max
}

fun findMinMax(array: IntArray): IntArray {
    var minMaxArray = intArrayOf(array[0], array[0])
    if (array.size == 1) {
        return minMaxArray
    }
    for (i in 1 until array.size) {
        minMaxArray[0] = Math.min(minMaxArray[0], array[i])
        minMaxArray[1] = Math.max(minMaxArray[1], array[i])
    }
    return minMaxArray
}