package com.dsa.dp.v;

public class BuyingCandies {
    public int solve(int[] A, int[] B, int[] C, int D) {

        // A[i] is no. of candies
        // B[i] is sweetness of candies
        // C[i] is cost of candies
        // D total cost

        // can also be done with D+1 space

        // dp[i][j] stores max sweetness possible from first i items and cost j
        int[][] dp = new int[A.length + 1][D + 1];

        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < D + 1; j++) {

                dp[i][j] = dp[i - 1][j]; //not selecting current item

                if (j >= C[i - 1]) { //by selecting item, compare which gives max profit
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - C[i - 1]] + (A[i - 1] * B[i - 1]));
                }
            }
        }
        return dp[A.length][D];
    }
}
