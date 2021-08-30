package com.dsa.dp.ii;

public class LongestCommonSubsequence {
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();

        //dp[i][j] stores lcs in A.subString(0,i) i.e (0 to i-1) and B.subString(0,j) i.e (0 to j-1)
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) { //if chars are same, add 1 to previous lcs
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]); //check which one has max lcs
                }
            }
        }
        return dp[n][m];
    }
}

