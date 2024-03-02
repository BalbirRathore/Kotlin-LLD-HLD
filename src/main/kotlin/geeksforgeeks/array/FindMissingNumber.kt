package org.example.geeksforgeeks.array

import java.util.*

internal class FindMissingNumber {


    companion object{
        @JvmStatic
        fun main(array: Array<String>){

            //val intArray = arrayOf(6,1,2,9,3,4,7,10,5)
            val intArray = intArrayOf(0,6,1,2,3,4,5,7)
            val size = intArray.size
            val findMissingNumber = FindMissingNumber()
            val missingNumber = findMissingNumber.getMissingNumber(intArray,size)
            println("missingNumber==${missingNumber}")
        }
    }

    private fun getMissingNumber1(array: Array<Int>, size: Int): Int {
        Arrays.sort(array)
        for (i in 1..size) {
            if (array.contains(i).not())
                return i
        }
        return 0
    }

    private fun getMissingNumber(array: IntArray, size: Int): Int {
        var sum = 0
        for (element in array) {
            sum += element
        }
        val totalMultiplication = (size * (size+1)) /2
        val missingNumber = totalMultiplication- sum
        return missingNumber
    }


}