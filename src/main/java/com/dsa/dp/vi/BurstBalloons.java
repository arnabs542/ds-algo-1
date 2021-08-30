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

