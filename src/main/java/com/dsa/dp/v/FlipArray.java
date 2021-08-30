package com.dsa.dp.v;

import java.util.Arrays;

public class FlipArray {
    public int solve(final int[] A) {

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        //dp[i][j] represents min. # of nos required to achieve sum j using first i values
        int[][] dp = new int[A.length + 1][sum + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE - 1); //can't get any sum with 0 values

        dp[0][0] = 0; //no no. is required to achieve sum 0 with 0 elements

        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                dp[i][j] = dp[i - 1][j]; //not considering current element

                if (j - A[i - 1] >= 0) { //consider current element, and compare both options
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - A[i - 1]]);
                }
            }
        }

        //refer class notes for sum/2 logic
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[A.length][j] != Integer.MAX_VALUE - 1 && dp[A.length][j] > 0) { //check first value > 0
                return dp[A.length][j];
            }
        }
        return 0;
    }
}

