package com.dsa.dp.viii;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public int solve(int[] A) {

        //refer class notes for explanation

        //dp[i][j] is min # of multiplications needed if we multiply ith to jth matrices
        int[][] dp = new int[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 3);
            dp[i][i] = 0;
        }

        //for length 2
        for (int i = 1; i < A.length - 1; i++) {
            dp[i][i + 1] = A[i - 1] * A[i] * A[i + 1];
        }

        //for length > 2
        for (int len = 3; len < A.length + 1; len++) {
            for (int i = 1; i + len - 1 < A.length; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], A[i - 1] * A[k] * A[j] + dp[i][k] + dp[k + 1][j]);
                }
            }
        }
        return dp[1][A.length - 1];
    }
}

