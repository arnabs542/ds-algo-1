package com.dsa.dp.ii;

public class LongestPalindromicSubsequence {
    public int solve(String A) {
        int n = A.length();

        int[][] dp = new int[n][n]; //dp[i][j] stores max palindrome length between i to j indices of A
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) { //consider all possible lengths
            for (int i = 0; i + len - 1 < n; i++) { //fix i

                int j = i + len - 1; //fix j

                if (A.charAt(i) == A.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];

        // String B = (new StringBuilder(A)).reverse().toString();
        // int n = A.length();
        // int m = B.length();

        // //dp[i][j] stores lcs in A.subString(0,i) i.e (0 to i-1) and B.subString(0,j) i.e (0 to j-1)
        // int[][] dp = new int[n + 1][m + 1];

        // for (int i = 1; i < n + 1; i++) {
        //     for (int j = 1; j < m + 1; j++) {
        //         if (A.charAt(i - 1) == B.charAt(j - 1)) { //if chars are same, add 1 to previous lcs
        //             dp[i][j] = 1 + dp[i - 1][j - 1];
        //         } else {
        //             dp[i][j] = Math.max(dp[i][j - 1],  dp[i - 1][j]); //check which one has max lcs
        //         }
        //     }
        // }
        // return dp[n][m];
    }
}

