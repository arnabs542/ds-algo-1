package com.dsa.dp.vi;

import java.util.ArrayList;
import java.util.HashMap;

public class ArithmeticSubsequences {
    public int solve(int[] A) {

        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>(); //no. -> occurence indices
        for (int i = 0; i < A.length; i++) {
            ArrayList<Integer> val = hashMap.getOrDefault(A[i], new ArrayList<>());
            val.add(i);
            hashMap.put(A[i], val);
        }

        //dp[i][j] represents no. of arithmetic sequence with last two as ith and jth no.
        int[][] dp = new int[A.length][A.length];

        int ans = 0;
        for (int k = 0; k < A.length; k++) { //fix k
            for (int j = 0; j < k; j++) { //fix j

                //search for i in hash map
                ArrayList<Integer> val = hashMap.getOrDefault(2 * A[j] - A[k], new ArrayList<>());

                int z = val.size();
                while (--z > -1) {
                    if (val.get(z) < j) { // i should be < j
                        dp[j][k] += 1 + dp[val.get(z)][j]; // additional 1 is for subsequence formed by i,j,k
                    }
                }
                ans += dp[j][k];
            }
        }
        return ans;
    }
}

