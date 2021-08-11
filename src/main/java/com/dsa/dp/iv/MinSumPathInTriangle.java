package com.dsa.dp.iv;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathInTriangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> A) {

        //same logic as minPathSum in 2D matrix
        int n = A.size();
        int m = A.get(n - 1).size();

        int[][] dp = new int[n + 1][m + 1]; //create one dummy column and row to avoid IndexOutOfBoundError
        //fill all max values
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[1][1] = A.get(0).get(0); //dp[i][j] represents minSum to reach i-1,j-1 from 0,0 (in original array)

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (i == 1 && j == 1)
                    continue;

                if ((j - 1) < A.get(i - 1).size()) { //check if the column exists, row would anyway exist
                    dp[i][j] = A.get(i - 1).get(j - 1) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]); //check from where we get minSum
                }
            }
        }

        int ans = Integer.MAX_VALUE; //need to just reach bottom, so take min of all last row values
        for (int i = 1; i < m + 1; i++) {
            ans = Math.min(ans, dp[n][i]);
        }
        return ans;
    }
}
/*
Min Sum Path in Triangle
Problem Description

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

Adjacent numbers for jth number of row i is jth and (j+1)th numbers of row i+1 is



Problem Constraints
|A| <= 1000

A[i] <= 1000



Input Format
First and only argument is the vector of vector A defining the given triangle



Output Format
Return the minimum sum



Example Input
Input 1:


A = [
         [2],
        [3, 4],
       [6, 5, 7],
      [4, 1, 8, 3]
    ]
Input 2:

 A = [ [1] ]


Example Output
Output 1:

 11
Output 2:

 1


Example Explanation
Explanation 1:

 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Explanation 2:

 Only 2 can be collected.

 */
