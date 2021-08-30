package com.dsa.dp.v;

public class UnboundedKnapsack {
    public int solve(int A, int[] B, int[] C) {

        //can also be done with A+1 space

        //dp[i][j] stores max profit possible from first i items and capacity j
        int[][] dp = new int[B.length + 1][A + 1];

        for (int i = 1; i < B.length + 1; i++) {
            for (int j = 1; j < A + 1; j++) {

                dp[i][j] = dp[i - 1][j]; //not selecting current item

                if (j >= C[i - 1]) { //by selecting same item again, compare which gives max profit
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - C[i - 1]] + B[i - 1]);
                }
            }
        }
        return dp[B.length][A];
    }
}

