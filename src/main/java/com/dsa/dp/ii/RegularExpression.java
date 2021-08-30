package com.dsa.dp.ii;

public class RegularExpression {
    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();

        //dp[i][j] stores if A.subString(0,i) i.e (0 to i-1) is matched by B.subString(0,j) i.e (0 to j-1)
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true; //both empty means its a match

        for (int j = 1; j < m + 1; j++) {
            if (B.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1]; //ignore the *, as nothing there to match in A
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (B.charAt(j - 1) == '?' || (B.charAt(j - 1) == A.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j - 1]; //check if matches till previous

                } else if (B.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j]; //ignore the * or match it till previous of A
                }
            }
        }
        return dp[n][m] ? 1 : 0;
    }
}