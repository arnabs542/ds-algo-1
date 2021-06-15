package com.dsa.hashing.i;

import java.util.HashSet;

public class SubarrayWith0Sum {
    public int solve(int[] A) {

        HashSet<Long> set = new HashSet<>();//contains prefixSums
        // add 0 initially because we may get currentSum as 0 at any point for which we need to return true
        // or else add another condition  if (set.contains(currentSum) || currentSum == 0)
        // set.add(0L);

        long currentSum = 0L;
        for (int i = 0; i < A.length; i++) {
            currentSum += Long.valueOf(A[i]);

            if (set.contains(currentSum) || currentSum == 0) {// if currentSum already exists, then there is a subarray with sum 0
                return 1;
            } else {
                set.add(currentSum);
            }
        }
        return 0;
    }
}
/*
Sub-array with 0 sum
Problem Description

Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1 else return 0.



Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return whether the given array contains a subarray with a sum equal to 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [-1, 1]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The array has sum 0.

 */