package org.example.geeksforgeeks.array

fun main(args: Array<String>) {
    val array = intArrayOf(1, 2, 1, 7, 5, 4, 5)
    val findMaxElementIndex = findPeakElementIndex(array)
    println("maxElement==${array[findMaxElementIndex]}")
}

fun findPeakElementIndex(nums: IntArray): Int {
    val size = nums.size
    if (size == 1)
        return 0
    if (nums[0] >= nums[1])
        return 0
    if (nums[size - 1] >= nums[size - 2])
        return size - 1
    for (i in 1 until size - 1) {
        if (nums[i] >= nums[i - 1] && nums[i] >= nums[i + 1])
            return i
    }
    return 0
}