package com.dsa.dp.ii;

public class DistinctSubsequences {
    public int numDistinct(String A, String B) {

        int n = A.length();
        int m = B.length();

        //dp[i][j] stores distinct subsequences of A.subString(0,i) i.e (0 to i-1) that equals B.subString(0,j) i.e (0 to j-1)
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) { //if B is empty, in one way we can form subsequence to match "", i.e by not considering anything in A
            dp[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (A.charAt(i - 1) != B.charAt(j - 1)) { //if chars are not same, consider previous value itself
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]; //if chars are same
                }
            }
        }
        return dp[n][m];
    }
}
