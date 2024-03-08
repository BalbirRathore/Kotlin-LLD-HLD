package org.example.geeksforgeeks.array.sort

import java.util.Arrays

fun main(args: Array<String>) {
    val array = intArrayOf(5, 4, 3, 2, 1)
    //println("called divideInSmallArray with array==${array.contentToString()}")
    val sortedArray = divideInSmallArray(array)
    println(sortedArray.contentToString())
}

private fun divideInSmallArray(array: IntArray): IntArray {
    if (array.size == 1)
        return array
    var mid = array.size / 2
    val leftSubArray = Arrays.copyOfRange(array, 0, mid)
    var leftArray = divideInSmallArray(leftSubArray)
    val rightSubArray = Arrays.copyOfRange(array, mid, array.size)
    var rightArray = divideInSmallArray(rightSubArray)
    val sortAndThenMergeArray = sortAndThenMerge(leftArray, rightArray)
    return sortAndThenMergeArray
}


private fun sortAndThenMerge(leftArray: IntArray, rightArray: IntArray): IntArray {

    var leftArrayIndex = 0
    var rightArrayIndex = 0
    var newArrayIndex = 0
    val newArray = IntArray(leftArray.size + rightArray.size)

/// compare left array with right array and whichever array's element is
// lesser then other array's element then that is stored in new array
    while (leftArrayIndex < leftArray.size && rightArrayIndex < rightArray.size) {
        if (leftArray[leftArrayIndex] < rightArray[rightArrayIndex]) {
            newArray[newArrayIndex] = leftArray[leftArrayIndex]
            leftArrayIndex++
        } else {
            newArray[newArrayIndex] = rightArray[rightArrayIndex]
            rightArrayIndex++
        }
        newArrayIndex++
    }

    // if any of array is not completed yet
    while (leftArrayIndex < leftArray.size) {
        newArray[newArrayIndex] = leftArray[leftArrayIndex]
        leftArrayIndex++
        newArrayIndex++
    }

    while (rightArrayIndex < rightArray.size) {
        newArray[newArrayIndex] = rightArray[rightArrayIndex]
        rightArrayIndex++
        newArrayIndex++
    }
    return newArray
}


private fun divideInSmallArrayWithPrintLogs(array: IntArray): IntArray {
    if (array.size == 1)
        return array
    var mid = array.size / 2
    val leftSubArray = Arrays.copyOfRange(array, 0, mid)
    println("called divideInSmallArray for leftSubArray ==${leftSubArray.contentToString()}")
    var leftArray = divideInSmallArray(leftSubArray)
    println("leftArray==${leftArray.contentToString()}")
    val rightSubArray = Arrays.copyOfRange(array, mid, array.size)
    println("called divideInSmallArray for rightSubArray==${rightSubArray.contentToString()}")
    var rightArray = divideInSmallArray(rightSubArray)
    println("rightArray==${rightArray.contentToString()}")
    val sortAndThenMergeArray = sortAndThenMerge(leftArray, rightArray)
    println("sortAndThenMerge==${sortAndThenMergeArray.contentToString()}")
    return sortAndThenMergeArray
}
