package com.dsa.dp.i;

public class Stairs {
    public int climbStairs(int A) {

        int[] dp = new int[A + 1];
        dp[0] = 1; //dp[0] = # ways to reach dummy stair (ground)
        dp[1] = 1; //dp[i] = # ways to reach ith step from 0th step = # ways to reach  i-1th step + # ways to reach  i-2th step

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[A];
    }
}
