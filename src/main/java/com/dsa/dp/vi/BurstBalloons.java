package com.dsa.dp.vi;

import java.util.ArrayList;
import java.util.Arrays;

public class BurstBalloons {
    private int[][] dp;

    public int solve(ArrayList<Integer> A) {

        //add 1 at begin and end for padding
        A.add(1);
        A.add(0, 1);

        dp = new int[A.size()][A.size()];
        //fill with -1
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recurse(0, A.size() - 1, A);
    }

    //returns max gain from subarray startIndex to endIndex, excluding startIndex and endIndex
    private int recurse(int startIndex, int endIndex, ArrayList<Integer> A) {

        if (startIndex + 1 == endIndex) {
            return 0;
        }

        //use memoized result
        if (dp[startIndex][endIndex] != -1) {
            return dp[startIndex][endIndex];
        }

        int ans = 0;
        // j is the last one to burst in the subarray from startIndex to endIndex, excluding startIndex and endIndex
        for (int j = startIndex + 1; j <= endIndex - 1; j++) {
            ans = Math.max(ans, recurse(startIndex, j, A) + recurse(j, endIndex, A) + A.get(startIndex) * A.get(j) * A.get(endIndex));
        }
        dp[startIndex][endIndex] = ans;

        return ans;
    }
}
/*
Burst Balloons
Problem Description

You are given N balloons each with a number of coins associated with them. An array of integers A represents the coins associated with the ith balloon.
You are asked to burst all the balloons. If the you burst balloon ith you will get A[left] * A[i] * A[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

NOTE: You may imagine A[-1] = A[N] = 1. They are not real therefore you can not burst them.



Problem Constraints
1 <= N <= 100
1 <= A[i] <= 100



Input Format
The only argument given is the integer array A.



Output Format
Return the maximum coins you can collect by bursting the balloons wisely.



Example Input
Input 1:

 A = [3, 1, 5, 8]
Input 2:

 A = [3, 1, 2]


Example Output
Output 1:

 167
Output 2:

 15


Example Explanation
Explanation 1:

 Burst ballon at index 1, coins collected = 3*1*5=15 , A becomes = [3, 5, 8]
 Burst ballon at index 1, coins collected = 3*5*8=120 , A becomes = [3, 8]
 Burst ballon at index 0, coins collected = 1*3*8=24 , A becomes = [8]
 Burst ballon at index 0, coins collected = 1*8*1 = 8
 Total coins collected = 15 + 120 + 24 + 8 = 167
Explanation 2:

 Burst ballon at index 1, coins collected = 3*1*2 = 6, A becomes = [3, 2]
 Burst ballon at index 1, coins collected = 3*2*1 = 6, A becomes = [3]
 Burst ballon at index 0, coins collected = 1*3*1 = 3
 Total coins collected = 6 + 6 + 3 = 15

 */
