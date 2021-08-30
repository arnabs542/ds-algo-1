package com.dsa.graphs.iii;

public class FloydWarshallAlgorithm {

    public int[][] solve(int[][] A) {

        int[][] dp = new int[A.length][A[0].length];

        //initialize with original values except where it is -1
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i][j] == -1) {
                    dp[i][j] = Integer.MAX_VALUE / 2;
                } else {
                    dp[i][j] = A[i][j];
                }
            }
        }

        //refer class notes for algo explanation
        for (int k = 0; k < A.length; k++) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        //put -1 as requested in question when no path exists
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (dp[i][j] == Integer.MAX_VALUE / 2) {
                    dp[i][j] = -1;
                }
            }
        }
        return dp;
    }
}

