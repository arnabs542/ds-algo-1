package com.dsa.dp.iii;

public class SubmatrixSumQueries {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {

        int mod = 1000000007;

        int n = A.length;
        int m = A[0].length;

        int[][] dp = new int[n + 1][m + 1]; //dp[i][j] stores sum of all elements in rectangle from 0,0 to i-1,j-1 of A

        //refer class notes for explanation
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = (((dp[i - 1][j] + dp[i][j - 1]) % mod + A[i - 1][j - 1]) % mod - dp[i - 1][j - 1] + mod) % mod;
            }
        }

        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int i1 = D[i];
            int j1 = E[i];
            int i2 = B[i];
            int j2 = C[i];

            ans[i] = ((dp[i1][j1] + dp[i2 - 1][j2 - 1]) % mod - ((dp[i1][j2 - 1] + dp[i2 - 1][j1]) % mod) + mod) % mod;
        }
        return ans;
    }
}
