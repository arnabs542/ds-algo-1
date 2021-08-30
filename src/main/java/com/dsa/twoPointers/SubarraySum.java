package com.dsa.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarraySum {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        long[] prefixSum = new long[A.size() + 1]; //store prefix sum values, prefixSum[1] = A[0]

        for (int i = 1; i < A.size() + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + A.get(i - 1);
        }
        int l = 0;
        int r = 1;

        while (r < prefixSum.length) {
            if (prefixSum[r] - prefixSum[l] > Long.valueOf(B)) {
                l++;
            } else if (prefixSum[r] - prefixSum[l] < Long.valueOf(B)) {
                r++;
            } else { //if diff. of two prefixSums equals B, means that there is a subarray with sum B
                return new ArrayList<>(A.subList(l, r));
            }
        }
        return new ArrayList<>(Arrays.asList(-1));
    }
}
