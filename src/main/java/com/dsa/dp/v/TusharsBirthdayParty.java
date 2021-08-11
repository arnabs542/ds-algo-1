package com.dsa.dp.v;

import java.util.Arrays;

public class TusharsBirthdayParty {
    public int solve(final int[] A, final int[] B, final int[] C) {

        // A[i] is eating capacities
        // B[i] is filling capacities
        // C[i] is cost

        //max eating capacity
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }

        // dp[i][j] stores min cost to satisfy person with capacity j using first i dishes
        int[][] dp = new int[B.length + 1][max + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE / 2); //can't satisfy with 0 dishes, so take cost as max
        dp[0][0] = 0; //cost to satisfy person with 0 capacity with 0 dishes

        for (int i = 1; i < B.length + 1; i++) {
            for (int j = 1; j < max + 1; j++) {

                dp[i][j] = dp[i - 1][j]; //not selecting current dish

                if (j >= B[i - 1]) { //by selecting current dish, compare which gives min cost
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - B[i - 1]] + C[i - 1]);
                }
            }
        }

        int ans = 0; //add up min cost to satisfy each friend
        for (int i = 0; i < A.length; i++) {
            ans += dp[B.length][A[i]];
        }
        return ans;
    }
}
/*
Tushar's Birthday Party
Problem Description

As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.

Each friend can take any dish unlimited number of times.

There always exists a dish with filling capacity 1 so that a solution always exists.



Problem Constraints
|A| <= 1000

|B| <= 1000

|C| <= 1000



Input Format
First Argument is vector A, denoting eating capacities

Second Argument is vector B, denoting filling capacities

Third Argument is vector C, denoting cost



Output Format
Return a single integer, the answer to the problem



Example Input
Input 1:

A = [2, 4, 6]
B = [2, 1, 3]
C = [2, 5, 3]
Input 2:

A = [2]
B = [1]
C = [2]


Example Output
Output 1:

12
Output 2:

4


Example Explanation
Explanation 1:

First friend takes dish 1, Second friend takes dish 1 twice and third friend takes dish 3 twice.
So 2 + 2*2 + 3*2 = 12.
Explanation 2:

Only way is to take 2 dishes of cost 2, hence 4.

 */
