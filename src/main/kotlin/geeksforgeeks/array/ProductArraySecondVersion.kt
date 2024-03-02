package org.example.geeksforgeeks.array

class ProductArraySecondVersion {

    /* Function to print product array
  for a given array arr[] of size n */

    fun productArray(inputArray: IntArray, n: Int) {
        // Base case
        val size = inputArray.size
        if (n == 1) {
            return
        }


    /*    val generatedStringArray = Array(10) { i -> i*i  }
        for(element in generatedStringArray)
        print("$element,")
        println()*/

        /*
         Allocate memory for the product array
         Initialize the product array as 1
         */
        val productArray = IntArray(n) { 1 }
        //for (j in 0 until n) productArray[j] = 1

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i != j) productArray[i] *= inputArray[j]
            }
        }
        // print the final output
        for(element in productArray){
            print("$element,")
        }
    }

    companion object {
        /* Driver program to test the above function */
        @JvmStatic
        fun main(args: Array<String>) {
            val pa = ProductArraySecondVersion()
            //val  nums = intArrayOf(-1,1,0,-3,3)
            val nums = intArrayOf(10, 3, 5, 6, 2)
            val n = nums.size
            //println("The product array is : ")
            pa.productArray(nums, n)
        }
    }
}