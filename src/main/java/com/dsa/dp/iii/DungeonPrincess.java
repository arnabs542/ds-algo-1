package com.dsa.dp.iii;

import java.util.Arrays;

public class DungeonPrincess {
    public int calculateMinimumHP(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        int[][] dp = new int[n + 1][m + 1]; //create one dummy column and row to avoid IndexOutOfBoundError
        //dp[i][j] represents minHealth needed to reach last cell from i,j

        //fill all max values
        for (int i = n; i >= 0; i--) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[n - 1][m - 1] = Math.max(1, 1 - A[n - 1][m - 1]); //minHealth needed to survive in last cell

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) //to avoid overridding
                    continue;
                dp[i][j] = Math.max(1, (Math.min(dp[i + 1][j], dp[i][j + 1]) - A[i][j])); //check from where we get minSum
            }
        }
        return dp[0][0];
    }
}

