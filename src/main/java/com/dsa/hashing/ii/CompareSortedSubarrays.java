package com.dsa.hashing.ii;

import java.util.HashMap;
import java.util.Random;

public class CompareSortedSubarrays {

    private HashMap<Integer, Long> hashValuesMap = new HashMap<>();

    public int[] solve(int[] A, int[][] B) {

        setHashValues(A); //hash each unique integer and put in hash map (to avoid collisions if we sum in the range [l1,r1] )
        int[] ans = new int[B.length];

        long[] prefixSum = new long[A.length + 1];
        prefixSum[0] = 0L;

        //calculate prefixSum
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + hashValuesMap.get(A[i - 1]);
        }

        for (int i = 0; i < B.length; i++) {
            int l1 = B[i][0];
            int r1 = B[i][1];
            int l2 = B[i][2];
            int r2 = B[i][3];

            long sum1 = prefixSum[r1 + 1] - prefixSum[l1];
            long sum2 = prefixSum[r2 + 1] - prefixSum[l2];

            ans[i] = (sum1 == sum2) ? 1 : 0; //if sum is same, put 1 else 0
        }
        return ans;
    }

    private void setHashValues(int[] A) {
        Random r = new Random();
        r.setSeed(System.nanoTime());

        for (int i = 0; i < A.length; i++) {
            if (!hashValuesMap.containsKey(A[i])) { //hash only if already not hashed
                hashValuesMap.put(A[i], r.nextLong()); //hash here is simply a random number
            }
        }
    }
}

