package com.dsa.dp.iii;

public class RepeatingSubsequence {
    public int anytwo(String A) {

        int n = A.length();

        //dp[i][j] stores lcs in A.subString(0,i) i.e (0 to i-1) and A.subString(0,j) i.e (0 to j-1) if (i != j)
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (A.charAt(i - 1) == A.charAt(j - 1) && i != j) { //if chars are same, and indexes are different
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]); //check which one has max lcs
                }
            }
        }
        return dp[n][n] >= 2 ? 1 : 0;
    }
}

