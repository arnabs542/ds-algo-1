package com.dsa.dp.i;

public class MaximumSum {
    public int solve(int[] A, int B, int C, int D) {

        //dp[0][i] stores max B*A[p]                    till i s.t p<=i
        //dp[1][i] stores max B*A[p] + C*A[q]           till i s.t p<=q<=i
        //dp[2][i] stores max B*A[p] + C*A[q] + D*A[r]  till i s.t p<=q<=r<=i
        int[][] dp = new int[3][A.length];
        dp[0][0] = B * A[0];
        dp[1][0] = B * A[0] + C * A[0];
        dp[2][0] = B * A[0] + C * A[0] + D * A[0];

        for (int i = 1; i < A.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], 0 + B * A[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i] + C * A[i]);
            dp[2][i] = Math.max(dp[2][i - 1], dp[1][i] + D * A[i]);
        }
        return dp[2][A.length - 1];
    }

}
