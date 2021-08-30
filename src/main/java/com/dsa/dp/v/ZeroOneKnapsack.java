package com.dsa.dp.v;

public class ZeroOneKnapsack {
    public int solve(int[] A, int[] B, int C) {

        //can also be done with C+1 space

        //dp[i][j] stores max profit possible from first i items and capacity j
        int[][] dp = new int[A.length + 1][C + 1];

        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < C + 1; j++) {

                dp[i][j] = dp[i - 1][j]; //not selecting current item

                if (j >= B[i - 1]) { //by selecting item, compare which gives max profit
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - B[i - 1]] + A[i - 1]);
                }
            }
        }
        return dp[A.length][C];
    }
}

