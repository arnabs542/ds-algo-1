package com.dsa.twoPointers;

import java.util.Arrays;

public class ThreeSum {
    public int threeSumClosest(int[] A, int B) {

        Arrays.sort(A);
        int ans = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            int requiredSum = B - A[i]; //search for A[l] + A[r] that is closest to requiredSum

            int l = i + 1;
            int r = A.length - 1;

            //basic two pointer approach
            while (l < r) {
                if (min > Math.abs(requiredSum - A[l] - A[r])) { //update min and ans
                    min = Math.abs(requiredSum - A[l] - A[r]);
                    ans = A[l] + A[r] + A[i];
                }
                if (A[l] + A[r] > requiredSum) {
                    r--;
                } else if (A[l] + A[r] < requiredSum) {
                    l++;
                } else {
                    return A[l] + A[r] + A[i];
                }
            }
        }
        return ans;
    }
}
/*
3 Sum
Problem Description

Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.



Problem Constraints
-108 <= B <= 108
1 <= N <= 104
-108 <= A[i] <= 108


Input Format
First argument is an integer array A of size N.

Second argument is an integer B denoting the sum you need to get close to.



Output Format
Return a single integer denoting the sum of three integers which is closest to B.



Example Input
Input 1:

A = [-1, 2, 1, -4]
B = 1
Input 2:


A = [1, 2, 3]
B = 6


Example Output
Output 1:

2
Output 2:

6


Example Explanation
Explanation 1:

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
Explanation 2:

 Take all elements to get exactly 6.
 */