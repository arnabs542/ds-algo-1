package com.dsa.greedy.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeleteMinMax {

    public int solve(ArrayList<Integer> A) {

        HashMap<Integer, Integer> map = new HashMap<>(); //to store # of occurrences of each number

        //idea is to pick 3 numbers that are same as much as possible
        for (int i = 0; i < A.size(); i++) {
            Integer count = map.getOrDefault(A.get(i), 0);

            if (count == 2) { //already have 2, means with new one can club as 3 together, resultant will be 1
                count = 1;
            } else {
                count++;
            }
            map.put(A.get(i), count);
        }

        int ones = 0; //no. of numbers with occurrence count as 1
        int twos = 0; //no. of numbers with occurrence count as 2
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() == 2) {
                twos++;
            } else {
                ones++;
            }
        }
        //ones will always be there in ans, twos if odd contribute one lesser (as it needs to be clubbed with one of the ones)
        return ones + (twos % 2 == 1 ? twos - 1 : twos);
    }
}
/*
Delete Min and Max
Problem Description

Given an array A, of N numbers, you want to keep only distinct numbers in the array.
To achieve this, you can pick any three numbers, and discard the maximum and minimum of the three, and keep the middle one back in the array.

Find the maximum number of distinct numbers in the array that will be left.



Problem Constraints
3 <= N <= 105
N is an odd number.
1 <= A[i] <= 105


Input Format
The first and the only argument of input contains an integer array A, of size N.



Output Format
Return an integer representing the answer.



Example Input
Input 1:

 A = [1, 1, 2]
Input 2:

 A = [1, 1, 2, 2, 2, 3, 1]


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 You can pick 1, 1, 2. After discarding minimum (1) and maximum (2) from the array, you will have [1] left.
Explanation 2:

 You can pick 2, 2, 2. After discarding minimum (2) and maximum (2) from the array, you will have [1, 1, 2, 3, 1] left.
 You can pick 1, 1, 1. After discarding minimum (1) and maximum (1) from the array, you will have [1, 2, 3] left.

 */