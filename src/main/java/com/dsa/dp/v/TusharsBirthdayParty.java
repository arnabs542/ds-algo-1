package com.dsa.dp.v;

import java.util.Arrays;

public class TusharsBirthdayParty {
    public int solve(final int[] A, final int[] B, final int[] C) {

        // A[i] is eating capacities
        // B[i] is filling capacities
        // C[i] is cost

        //max eating capacity
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }

        // dp[i][j] stores min cost to satisfy person with capacity j using first i dishes
        int[][] dp = new int[B.length + 1][max + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE / 2); //can't satisfy with 0 dishes, so take cost as max
        dp[0][0] = 0; //cost to satisfy person with 0 capacity with 0 dishes

        for (int i = 1; i < B.length + 1; i++) {
            for (int j = 1; j < max + 1; j++) {

                dp[i][j] = dp[i - 1][j]; //not selecting current dish

                if (j >= B[i - 1]) { //by selecting current dish, compare which gives min cost
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - B[i - 1]] + C[i - 1]);
                }
            }
        }

        int ans = 0; //add up min cost to satisfy each friend
        for (int i = 0; i < A.length; i++) {
            ans += dp[B.length][A[i]];
        }
        return ans;
    }
}

