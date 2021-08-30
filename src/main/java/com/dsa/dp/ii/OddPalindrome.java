package com.dsa.dp.ii;

import java.util.Arrays;

public class OddPalindrome {
    public int[] solve(String A) {

        int mod = 1000000007;
        //very difficult question
        //refer class notes for visualisation and approach
        String B = (new StringBuilder(A)).reverse().toString();
        int n = A.length();

        //dp[i][j] stores no. of common subsequences in A.subString(0,i) i.e (0 to i-1) and B.subString(0,j) i.e (0 to j-1)
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], 1); // common subsequences between "" & "anyChar" = 1
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                dp[i][j] = ((dp[i - 1][j] + dp[i][j - 1]) % mod - dp[i - 1][j - 1] + mod) % mod;

                if (A.charAt(i - 1) == B.charAt(j - 1)) { //if chars are same
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (dp[i][n - i - 1]) % mod;
        }
        return ans;
    }
}

