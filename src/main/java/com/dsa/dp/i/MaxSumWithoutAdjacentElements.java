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
