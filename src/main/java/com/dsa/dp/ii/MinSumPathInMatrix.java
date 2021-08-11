package com.dsa.dp.ii;

import java.util.Arrays;

public class MinSumPathInMatrix {
    public int minPathSum(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        int[][] dp = new int[2][m + 1]; //create one dummy column and row to avoid IndexOutOfBoundError
        //fill all max values
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[1][1] = A[0][0]; //dp[i][j] represents minSum to reach i-1,j-1 from 0,0 (in original array)

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (i == 1 && j == 1)
                    continue;

                dp[i % 2][j] = A[i - 1][j - 1] + Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]); //check from where we get minSum
            }
        }
        return dp[n % 2][m];
    }
}
/*
Min Sum Path in Matrix
Problem Description

Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Return the minimum sum of the path.

NOTE: You can only move either down or right at any point in time.



Problem Constraints
1 <= M, N <= 2000

-1000 <= A[i][j] <= 1000



Input Format
First and only argument is a 2-D grid A.



Output Format
Return an integer denoting the minimum sum of the path.



Example Input
Input 1:

 A = [
       [1, 3, 2]
       [4, 3, 1]
       [5, 6, 1]
     ]
Input 2:

 A = [
       [1, -3, 2]
       [2, 5, 10]
       [5, -5, 1]
     ]


Example Output
Output 1:

 8
Output 2:

 -1


Example Explanation
Explanation 1:

 The path will be: 1 -> 3 -> 2 -> 1 -> 1.
Input 2:

 The path will be: 1 -> -3 -> 5 -> -5 -> 1.

 */
