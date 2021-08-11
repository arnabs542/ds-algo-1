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
/*
Minimum Number of Squares
Problem Description

Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.



Problem Constraints
1 <= A <= 105



Input Format
First and only argument is an inetegr A.



Output Format
Return an integer denoting the minimum count.



Example Input
Input 1:

 A = 6
Input 2:

 A = 5


Example Output
Output 1:

 3
Output 2:

 2


Example Explanation
Explanation 1:

 Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 Minimum count of numbers, sum of whose squares is 6 is 3.
Explanation 2:

 We can represent 5 using only 2 numbers i.e. 12 + 22 = 5

 */