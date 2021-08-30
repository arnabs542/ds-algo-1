package com.dsa.dp.iii;

public class CoinSumInfinite {
    public int coinchange2(int[] A, int B) {

        // 1. when order doesn't matter
        int[] dp = new int[B + 1]; //dp[i] stores # of ways of forming sum i
        dp[0] = 1; // 0 can be formed by not taking any coins

        for (int i = 0; i < A.length; i++) {// for each coin
            for (int j = A[i]; j <= B; j++) { // sum j can be formed using a particular coin
                dp[j] = (dp[j] + dp[j - A[i]]) % 1000007;
            }
        }

        // 2. when order matters
        // for (int j = 0; j <= B; j++) {
        //     for (int i = 0; i < A.length; i++) {
        //         if (j >= A[i]) {
        //             dp[j] = (dp[j] + dp[j - A[i]]) % 1000007;
        //         }
        //     }
        // }
        return dp[B];
    }
}

