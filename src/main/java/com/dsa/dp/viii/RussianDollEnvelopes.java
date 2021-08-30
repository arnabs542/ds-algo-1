package com.dsa.dp.viii;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public int solve(int[][] A) {

        //sort on widths, if widths are equal then sort desc on heights
        Comparator<int[]> customComparator = (a, b) -> {
            if (a[1] == b[1])
                return Integer.valueOf(b[0]).compareTo(Integer.valueOf(a[0]));
            return Integer.valueOf(a[1]).compareTo(Integer.valueOf(b[1]));
        };
        Arrays.sort(A, customComparator);

        int[] arr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i][0];
        }
        return longestIncreasingSubsequence(arr); //lis on heights of sorted widths
    }

    private int longestIncreasingSubsequence(int[] A) {

        if (A.length <= 1) {
            return A.length;
        }

        //dp[i] represents the LIS ending at ith index
        int[] dp = new int[A.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < A.length; j++) {
            for (int i = 0; i < j; i++) {
                if (A[i] < A[j]) {
                    dp[j] = Math.max(dp[j], 1 + dp[i]);
                }
                ans = Math.max(ans, dp[j]);
            }
        }
        return ans;
    }
}

