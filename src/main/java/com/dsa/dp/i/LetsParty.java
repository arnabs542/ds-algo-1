package com.dsa.dp.i;

public class LetsParty {
    public int solve(int A) {

        int[] dp = new int[A + 1]; //dp[i] = # of ways of partying with i people
        dp[0] = 1;
        dp[1] = 1;

        //two choices
        //1. dances alone, then no. of ways = dp[i-1]
        //2. he chooses to pair up with one of remaining i-1 ppl, then no. of ways = i-1 * dp[i-2] as i-2 ppl will be leftout
        for (int i = 2; i <= A; i++) {
            dp[i] = (dp[i - 1] + ((i - 1) * dp[i - 2]) % 10003) % 10003;
        }
        return dp[A];
    }
}
