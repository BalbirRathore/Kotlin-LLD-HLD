package org.example.geeksforgeeks.array

import kotlin.math.max

fun main(args: Array<String>) {
    val array = intArrayOf(1, 2, 3, -2, 5)
    val maxSumOfContiguousSubArray = findMaxSumOfContiguousSubArray(array)
    println("maxSumOfContiguousSubArray==$maxSumOfContiguousSubArray")
}

// Kadane's Algorithm
fun findMaxSumOfContiguousSubArray(array: IntArray): Int {
       var sum = 0
       var maxi = array[0]
       for(element in array){
           //first step
           sum += element
           //second step
           maxi = max(maxi,sum)
           //third step
           if(sum<0)
               sum = 0
       }
    return sum
}
