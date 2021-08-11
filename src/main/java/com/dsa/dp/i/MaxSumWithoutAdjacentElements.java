package com.dsa.dp.i;

public class MaxSumWithoutAdjacentElements {
    public int adjacent(int[][] A) {

        if (A[0].length == 1)
            return Math.max(A[0][0], A[1][0]);

        int[] dp = new int[A[0].length];
        dp[0] = Math.max(A[0][0], A[1][0]); //dp[i] = max sum possible till ith index such that ith index was last
        dp[1] = Math.max(dp[0], Math.max(A[0][1], A[1][1]));

        //consider current elem (max among ith column values) + dp[i-2], as adjacent needs to be leftout
        //consider only till dp[i-1]
        //pick max out of above two
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(A[0][i], A[1][i]) + dp[i - 2]);
        }

        return dp[dp.length - 1];
    }
}
/*
Max Sum Without Adjacent Elements
Problem Description

Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Note: You can choose more than 2 numbers.



Problem Constraints
1 <= N <= 20000
1 <= A[i] <= 2000



Input Format
The first and the only argument of input contains a 2d matrix, A.



Output Format
Return an integer, representing the maximum possible sum.



Example Input
Input 1:

 A = [
        [1]
        [2]
     ]
Input 2:

 A = [
        [1, 2, 3, 4]
        [2, 3, 4, 5]
     ]


Example Output
Output 1:

 2
Output 2:

 8


Example Explanation
Explanation 1:

 We will choose 2.
Explanation 2:

 We will choose 3 and 5.

 */