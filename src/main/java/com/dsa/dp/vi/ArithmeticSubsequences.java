package com.dsa.dp.vi;

import java.util.ArrayList;
import java.util.HashMap;

public class ArithmeticSubsequences {
    public int solve(int[] A) {

        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>(); //no. -> occurence indices
        for (int i = 0; i < A.length; i++) {
            ArrayList<Integer> val = hashMap.getOrDefault(A[i], new ArrayList<>());
            val.add(i);
            hashMap.put(A[i], val);
        }

        //dp[i][j] represents no. of arithmetic sequence with last two as ith and jth no.
        int[][] dp = new int[A.length][A.length];

        int ans = 0;
        for (int k = 0; k < A.length; k++) { //fix k
            for (int j = 0; j < k; j++) { //fix j

                //search for i in hash map
                ArrayList<Integer> val = hashMap.getOrDefault(2 * A[j] - A[k], new ArrayList<>());

                int z = val.size();
                while (--z > -1) {
                    if (val.get(z) < j) { // i should be < j
                        dp[j][k] += 1 + dp[val.get(z)][j]; // additional 1 is for subsequence formed by i,j,k
                    }
                }
                ans += dp[j][k];
            }
        }
        return ans;
    }
}
/*
Arithmetic Subsequences
Problem Description

A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

 1, 3, 5, 7, 9
 7, 7, 7, 7
Given an integer array A of size N. A subsequence slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.

A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk](0-based indexing) is arithmetic. In particular, this means that k ≥ 2.

Return the number of arithmetic subsequences slices in the array A.



Problem Constraints
1 <= N <= 1000

-105 <= A[i] <= 105



Input Format
The first and the only argument of input contains an integer array, A of size N.



Output Format
Return an integer representing the number of arithmetic subsequences in A.



Example Input
Input 1:

 A = [2, 4, 6, 8, 10]
Input 2:

 A = [3, 6, 7]


Example Output
Output 1:

 7
Output 2:

 0


Example Explanation
Explanation 1:

 All arithmetic subsequence slices are:
    [2, 4, 6]
    [4, 6, 8]
    [6, 8, 10]
    [2, 4, 6, 8]
    [4, 6, 8, 10]
    [2, 4, 6, 8, 10]
    [2, 6, 10]
Explanation 2:

 There are no possible arithmetic subseqence.

 */
