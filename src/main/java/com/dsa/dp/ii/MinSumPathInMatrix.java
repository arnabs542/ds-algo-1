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

