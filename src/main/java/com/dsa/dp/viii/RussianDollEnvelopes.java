package com.dsa.dp.viii;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public int solve(int[][] A) {

        //sort on widths, if widths are equal then sort desc on heights
        Comparator<int[]> customComparator = (a, b) -> {
            if (a[1] == b[1])
                return Integer.valueOf(b[0]).compareTo(Integer.valueOf(a[0]));
            return Integer.valueOf(a[1]).compareTo(Integer.valueOf(b[1]));
        };
        Arrays.sort(A, customComparator);

        int[] arr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i][0];
        }
        return longestIncreasingSubsequence(arr); //lis on heights of sorted widths
    }

    private int longestIncreasingSubsequence(int[] A) {

        if (A.length <= 1) {
            return A.length;
        }

        //dp[i] represents the LIS ending at ith index
        int[] dp = new int[A.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < A.length; j++) {
            for (int i = 0; i < j; i++) {
                if (A[i] < A[j]) {
                    dp[j] = Math.max(dp[j], 1 + dp[i]);
                }
                ans = Math.max(ans, dp[j]);
            }
        }
        return ans;
    }
}
/*
Russian Doll Envelopes
Problem Description

Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.

One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

Find the maximum number of envelopes you can put one inside other.



Problem Constraints
1 <= N <= 1000
1 <= A[i][0], A[i][1] <= 109



Input Format
The only argument given is the integer matrix A.



Output Format
Return an integer denoting the maximum number of envelopes you can put one inside other.



Example Input
Input 1:

 A = [
         [5, 4]
         [6, 4]
         [6, 7]
         [2, 3]
     ]
Input 2:

 A = [     '
         [8, 9]
         [8, 18]
     ]


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 Step 1: put [2, 3] inside [5, 4]
 Step 2: put [5, 4] inside [6, 7]
 3 envelopes can be put one inside other.
Explanation 2:

 No envelopes can be put inside any other so answer is 1.

 */
