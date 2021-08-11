package com.dsa.dp.v;

public class UnboundedKnapsack {
    public int solve(int A, int[] B, int[] C) {

        //can also be done with A+1 space

        //dp[i][j] stores max profit possible from first i items and capacity j
        int[][] dp = new int[B.length + 1][A + 1];

        for (int i = 1; i < B.length + 1; i++) {
            for (int j = 1; j < A + 1; j++) {

                dp[i][j] = dp[i - 1][j]; //not selecting current item

                if (j >= C[i - 1]) { //by selecting same item again, compare which gives max profit
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - C[i - 1]] + B[i - 1]);
                }
            }
        }
        return dp[B.length][A];
    }
}
/*
Unbounded Knapsack
Problem Description

Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.

This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.



Problem Constraints
1 <= A <= 1000

1 <= |B| <= 1000

1 <= B[i] <= 1000

1 <= C[i] <= 1000



Input Format
First argument is the Weight of knapsack A

Second argument is the vector of values B

Third argument is the vector of weights C



Output Format
Return the maximum value that fills the knapsack completely



Example Input
Input 1:

A = 10
B = [5]
C = [10]
Input 2:

A = 10
B = [6, 7]
C = [5, 5]


Example Output
Output 1:

 5
Output 2:

14


Example Explanation
Explanation 1:

Only valid possibility is to take the given item.
Explanation 2:

Take the second item twice.

 */
