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
/*
Coin Sum Infinite
Problem Description

You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

NOTE:

Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).


Problem Constraints
1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000



Input Format
First argument is an integer array A representing the set.
Second argument is an integer B.



Output Format
Return an integer denoting the number of ways.



Example Input
Input 1:

 A = [1, 2, 3]
 B = 4
Input 2:

 A = [10]
 B = 10


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 The 4 possible ways are:
 {1, 1, 1, 1}
 {1, 1, 2}
 {2, 2}
 {1, 3}
Explanation 2:

 There is only 1 way to make sum 10.

 */
