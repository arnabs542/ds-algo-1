package com.dsa.dp.iv;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathInTriangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> A) {

        //same logic as minPathSum in 2D matrix
        int n = A.size();
        int m = A.get(n - 1).size();

        int[][] dp = new int[n + 1][m + 1]; //create one dummy column and row to avoid IndexOutOfBoundError
        //fill all max values
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[1][1] = A.get(0).get(0); //dp[i][j] represents minSum to reach i-1,j-1 from 0,0 (in original array)

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (i == 1 && j == 1)
                    continue;

                if ((j - 1) < A.get(i - 1).size()) { //check if the column exists, row would anyway exist
                    dp[i][j] = A.get(i - 1).get(j - 1) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]); //check from where we get minSum
                }
            }
        }

        int ans = Integer.MAX_VALUE; //need to just reach bottom, so take min of all last row values
        for (int i = 1; i < m + 1; i++) {
            ans = Math.min(ans, dp[n][i]);
        }
        return ans;
    }
}

