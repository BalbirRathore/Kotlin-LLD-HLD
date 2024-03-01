package org.example.geeksforgeeks


internal class ProductArray {
    /* Function to print product array
    for a given array arr[] of size n */
    fun productArray1(arr: IntArray, n: Int) {
        // Base case
        if (n == 1) {
            return
        }
        // Initialize memory to all arrays
        val left = IntArray(n)
        val right = IntArray(n)
        val prod = IntArray(n)

        /* Left most element of left array is always 1 */
        left[0] = 1
        /* Right most element of right array is always 1 */
        right[n - 1] = 1
        // 1, 10, 30, 150, 900,
        /* Construct the left array */
        var i = 1
        while (i < n) {
            left[i] = arr[i - 1] * left[i - 1]
            print("${left[i]}, ")
            i++
            //print(prod[i].toString() + " ")
        }

        /* Construct the right array */
        var j = n - 2
        println()
        while (j >= 0) {
            right[j] = arr[j + 1] * right[j + 1]
            print("${right[j]}, ")
            j--
        }

        /* Construct the product array using
        left[] and right[] */
        i = 0
        while (i < n) {
            prod[i] = left[i] * right[i]
            i++
        }

        /* print the constructed prod array */
        i = 0
        while (i < n) {
            print(prod[i].toString() + " ")
            i++
        }
        return
    }


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