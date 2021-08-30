package com.dsa.dp.i;

public class MinimumNumberOfSquares {
    public int countMinSquares(int A) {

        int[] dp = new int[A + 1]; //dp[i] = # of no.s whose squares add up to i

        for (int i = 1; i <= A; i++) {
            dp[i] = i; //worst case, for eg: 13 = 1^2 + 1^2 + ...... (13 times)
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - (j * j)]); // j = 3, dp[13] = min(13, 1 + dp[13-9])
            }
        }
        return dp[dp.length - 1];
    }
}
