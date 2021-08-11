package com.dsa.dp.iii;

import java.util.Arrays;
import java.util.HashMap;

public class LongestFibonacciSubsequence {

    public int solve(int[] A) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            hashMap.put(A[i], i);
        }

        //dp[i][j] represents longest fib sequence with last two as ith and jth no.
        int[][] dp = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) { //any two no.s can be part of fib sequence
            Arrays.fill(dp[i], 2);
        }

        int ans = 0;
        for (int k = 0; k < A.length; k++) { //fix k
            for (int j = 0; j < k; j++) { //fix j

                int elem = A[k] - A[j]; //search for i in hash map
                int val = hashMap.getOrDefault(elem, -1);

                if (val != -1 && val < j) { // i should be < j
                    dp[j][k] = 1 + dp[val][j];
                    ans = Math.max(ans, dp[j][k]); //update global ans
                }
            }
        }
        return ans;
    }
}
/*
Length of Longest Fibonacci Subsequence
Problem Description

Given a strictly increasing array A of positive integers forming a sequence.

A sequence X1, X2, X3, ..., XN is fibonacci like if


N > =3
Xi + Xi+1 = Xi+2 for all i+2 <= N
Find and return the length of the longest Fibonacci-like subsequence of A.

If one does not exist, return 0.

NOTE: A subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.



Problem Constraints
3 <= length of the array <= 1000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the length of the longest Fibonacci-like subsequence of A.
If one does not exist, return 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5, 6, 7, 8]
Input 2:

 A = [1, 3, 7, 11, 12, 14, 18]


Example Output
Output 1:

 5
Output 2:

 3


Example Explanation
Explanation 1:

 The longest subsequence that is fibonacci-like: [1, 2, 3, 5, 8].
Explanation 2:

 The longest subsequence that is fibonacci-like: [1, 11, 12], [3, 11, 14] or [7, 11, 18].
 The length will be 3.

 */
