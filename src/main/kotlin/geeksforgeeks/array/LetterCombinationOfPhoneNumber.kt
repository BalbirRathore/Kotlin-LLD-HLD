package org.example.geeksforgeeks.array

import java.util.*


internal class LetterCombinationOfPhoneNumber {
    // Function to return a vector that contains
    // all the generated letter combinations
    private fun letterCombinationsUtil(digits: String,
                                       table: Array<String>
    ): List<String> {
        // To store the generated letter combinations
        val list = ArrayList<String>()
        //val queue: Queue<String> = LinkedList()
        val queue : Queue<String> = LinkedList()
        queue.add("")
        while (queue.isNotEmpty() && digits.isNotEmpty()) {
            val s = queue.remove()
            // If complete word is generated
            // push it in the list
            if (s.length == digits.length)
                list.add(s)
            else {
                val value = table[digits[s.length].digitToInt()]
                for (element in value) {
                    queue.add(s + element)
                }
            }
        }
        return list
    }

    // Function that creates the mapping and
    // calls letterCombinationsUtil
    private fun letterCombinations(digits: String) {
        // table[i] stores all characters that
        // corresponds to ith digit in phone
        val table = arrayOf(
            "0", "1", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        )

        val list = letterCombinationsUtil(digits,  table)
        // Print the contents of the list
        println(list)
      /*  for (i in list.indices) {
            print(list[i] + " ")
        }*/
    }

    // Driver code
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val letterCombinationOfPhoneNumber = LetterCombinationOfPhoneNumber()
            //val number = intArrayOf(2, 3)
            //val n = number.size
            val digits = ""
            // Function call
            letterCombinationOfPhoneNumber.letterCombinations(digits);
        }
    }
}


