package org.example.geeksforgeeks


internal class ProductArray {
    /* Function to print product array
    for a given array arr[] of size n */

    fun productArray(arr: IntArray, n: Int) {
        // Base case
        val size = arr.size

        if (n == 1) {
            print("0")
            return
        }
        var temp = 1

        /* Allocate memory for the product array */
        val prod = IntArray(n)

        /* Initialize the product array as 1 */
        for (j in 0 until n) prod[j] = 1

        //(10, 3, 5, 6, 2)
        /* In this loop, temp variable contains product of
           elements on left side excluding arr[i] */
        var i = 0
        while (i < n) {
            prod[i] = temp
            temp *= arr[i]
            print("${prod[i]},")
            i++
        }

        println()
        /* Initialize temp to 1 for product on right side */
        temp = 1
        /* In this loop, temp variable contains product of
           elements on right side excluding arr[i] */
        //(10, 3, 5, 6, 2)
        i = n - 1
        while (i >= 0) {
            prod[i] *= temp
            temp *= arr[i]
            print("${prod[i]},")
            i--
        }

        /* print the constructed prod array */
        println()
        i = 0
        while (i < n) {
            print(prod[i].toString() + " ")
            i++
        }
        return
    }

    companion object {
        /* Driver program to test the above function */
        @JvmStatic
        fun main(args: Array<String>) {
            val pa = ProductArray()
           //val  nums = intArrayOf(-1,1,0,-3,3)
            val nums = intArrayOf(10, 3, 5, 6, 2)
            val n =  nums.size
            //println("The product array is : ")
            pa.productArray(nums, n)
            val array = arrayOfNulls<Int>(5)
        }
    }
}