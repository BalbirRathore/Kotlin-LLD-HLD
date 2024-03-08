package org.example.geeksforgeeks.array.sort

fun main(args: Array<String>) {
    val array = intArrayOf(50, 40, 30, 20, 10)
    //val array = intArrayOf(50, 40, 60, 70, 80)
    val sortedArray = performSelectionSort(array)
    //val sortedArray = performBubbleSort(array)
    sortedArray.forEach {
        print("$it,")
    }
}

private fun performSelectionSort(array: IntArray): IntArray {
    for (i in array.indices) {
        for (j in i + 1 until array.size) {
            if (array[j] < array[i]) {
                performSwapForSelectionSort(array, j, i)
            }
        }
    }
    return array
}


private fun performBubbleSort(nums: IntArray): IntArray {
    for (i in nums.indices) {
        var isSwap = false
        for (j in 0 until nums.size - 1 - i) {
            if (nums[j] > nums[j + 1]) {
                isSwap = performSwapForBubbleSort(nums, j, isSwap)
            }
        }
        if (isSwap.not())
            break
        print("i==$i,")
    }
    return nums
}

private fun performSwapForBubbleSort(nums: IntArray, j: Int, isSwap: Boolean): Boolean {
    var isSwap1 = isSwap
    performSwapForSelectionSort(nums, j, j + 1)
    isSwap1 = true
    return isSwap1
}

private fun performSwapForSelectionSort(array: IntArray, j: Int, i: Int) {
    var min = array[j]
    array[j] = array[i]
    array[i] = min
}


