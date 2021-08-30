package com.dsa.dp.iv;

public class IntersectingChordsInCircle {
    public int chordCnt(int A) {

        int mod = 1000000007;

        long[] dp = new long[A + 1]; //dp[i] represents no. of chords possible with 2*i points
        dp[0] = 1L;
        dp[1] = 1L;

        //dp[n] follows catalan number, can be done directly using formula, refer notes
        for (int i = 2; i < A + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[i] + (dp[j] * dp[i - j - 1]) % mod) % mod;
            }
        }
        return (int) dp[A];
    }
}

