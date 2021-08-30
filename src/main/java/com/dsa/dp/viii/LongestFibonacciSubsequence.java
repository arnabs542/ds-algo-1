package com.dsa.dp.viii;

import java.util.Arrays;
import java.util.HashMap;

public class LongestFibonacciSubsequence {
    public int solve(int[] A) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            hashMap.put(A[i], i);
        }

        //dp[i][j] represents longest fib sequence with last two as ith and jth no.
        int[][] dp = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) { //any two no.s can be part of fib sequence
            Arrays.fill(dp[i], 2);
        }

        int ans = 0;
        for (int k = 0; k < A.length; k++) { //fix k
            for (int j = 0; j < k; j++) { //fix j

                int elem = A[k] - A[j]; //search for i in hash map
                int val = hashMap.getOrDefault(elem, -1);

                if (val != -1 && val < j) { // i should be < j
                    dp[j][k] = 1 + dp[val][j];
                    ans = Math.max(ans, dp[j][k]); //update global ans
                }
            }
        }
        return ans;
    }
}

