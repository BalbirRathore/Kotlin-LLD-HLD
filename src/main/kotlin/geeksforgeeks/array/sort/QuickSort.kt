package org.example.geeksforgeeks.array.sort

fun main(args: Array<String>) {
    val nums = intArrayOf(55, 45, 23, 64, 22, 59)
    quickSort(nums, 0, (nums.size - 1))
    println(nums.contentToString())
}

private fun quickSort(nums: IntArray, lowerBound: Int, upperBound: Int) {
    if (lowerBound >= upperBound)
        return
    var startIndex = lowerBound
    var endIndex = upperBound
    var mid = startIndex + (endIndex - startIndex) / 2
    var pivot = nums[mid]
    while (startIndex <= endIndex) {
        while (nums[startIndex] < pivot) {
            startIndex++
        }
        while (nums[endIndex] > pivot) {
            endIndex--
        }
        if (startIndex <= endIndex) {
            var temp = nums[startIndex]
            nums[startIndex] = nums[endIndex]
            nums[endIndex] = temp
            startIndex++
            endIndex--
        }
    }
    quickSort(nums, lowerBound, endIndex)
    quickSort(nums, startIndex, upperBound)
}